package server.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

public class GenEntityMysql {

    private String packageOutPath = "server.entity";//指定实体生成所在包的路径
    private String tablename = "user_info";//表名
    private String[] colnames; // 列名数组
    private String[] colTypes; //列名类型数组
    private int[] colSizes; //列名大小数组
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*

    //数据库连接
    private static final String URL = "jdbc:mysql://localhost:3306/super_vcd";
    private static final String NAME = "root";
    private static final String PASS = "123456";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    /*
     * 构造函数
     */
    public GenEntityMysql() {
        //创建连接
        Connection con;
        //查要生成实体类的表
        String sql = "select * from " + tablename;
        PreparedStatement pStemt = null;
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            con = DriverManager.getConnection(URL, NAME, PASS);
            pStemt = con.prepareStatement(sql);
            ResultSetMetaData rsmd = pStemt.getMetaData();
            int size = rsmd.getColumnCount();   //统计列
            colnames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            for (int i = 0; i < size; i++) {
                colnames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);
                if (colTypes[i].equalsIgnoreCase("datetime")) {
                    f_util = true;
                }
                if (colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")) {
                    f_sql = true;
                }
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }

            String content = parse(colnames, colTypes, colSizes);

            try {
                File directory = new File("");
                //System.out.println("绝对路径："+directory.getAbsolutePath());
                //System.out.println("相对路径："+directory.getCanonicalPath());
                String path = this.getClass().getResource("").getPath();

                System.out.println(path);
                System.out.println("src/?/" + path.substring(path.lastIndexOf("/SuperVCD/", path.length())));
//              String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initcap(tablename) + ".java";
                String outputPath = directory.getAbsolutePath() + "/src/" + this.packageOutPath.replace(".", "/") + "/" + initcap(tablename) + ".java";
                FileWriter fw = new FileWriter(outputPath);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//          try {
//              con.close();
//          } catch (SQLException e) {
//              // TODO Auto-generated catch block
//              e.printStackTrace();
//          }
        }
    }

    /**
     * 功能：生成实体类主体代码
     *
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + this.packageOutPath + ";\r\n");
        //判断是否导入工具包
        if (f_util) {
            sb.append("import java.util.Date;\r\n");
        }
        if (f_sql) {
            sb.append("import java.sql.*;\r\n");
        }
        sb.append("\r\n");
        //注释部分
        sb.append("/**\r\n");
        sb.append(" * " + tablename + " 实体类\r\n");
        sb.append(" */ \r\n");
        //实体部分
        sb.append("\r\n\r\npublic class " + initcap(tablename) + " {\r\n");
        processAllAttrs(sb);//属性
        processAllMethod(sb);//get set方法
        sb.append("}\r\n");

        //System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 功能：生成所有属性
     *
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {

        for (int i = 0; i < colnames.length; i++) {
            System.out.println("types: " +colTypes[i] + "   colNames:" + colnames[i]);
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + getCamelCase(colnames[i]) + ";\r\n");
        }

    }

    /**
     * 获取驼峰命名法名称
     *
     * @param str
     * @return
     */
    private String getCamelCase(String str) {

        char[] strs = str.toCharArray();
        int count = 0;
        // '_'个数
        int i = 0;
        int len = strs.length;
        while (i < len) {
            if ('_' == strs[i]) {
                count++;
                int j = i + 1;
                // 小写转大写
                strs[j] -= 32;
                // 向前覆盖
                while (j < len) {
                    strs[j - 1] = strs[j];
                    j++;
                }
                len--;
            }
            i++;
        }
        return new String(strs, 0, strs.length - count);
    }

    /**
     * 功能：生成所有方法
     *
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {
        // 方法与属性之间空一行
        sb.append("\n");
        for (int i = 0; i < colnames.length; i++) {
            sb.append("    public void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " " +
                    getCamelCase(colnames[i]) + ") {\r\n");
            sb.append("        this." + getCamelCase(colnames[i]) + " = " + getCamelCase(colnames[i]) + ";\r\n");
            sb.append("    }\r\n\n");
            sb.append("    public " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "() {\r\n");
            sb.append("        return " + getCamelCase(colnames[i]) + ";\r\n");
            sb.append("    }\r\n\n");
        }

    }

    /**
     * 功能：将输入字符串的首字母改成大写
     *
     * @param str
     * @return
     */
    private String initcap(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        String campStr = getCamelCase(new String(ch));
        return campStr;
    }

    /**
     * 功能：获得列的数据类型
     *
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType) {

        if (sqlType.equalsIgnoreCase("bit")) {
            return "boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return "byte";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "short";
        } else if (sqlType.equalsIgnoreCase("int")) {
            return "int";
        }else if (sqlType.equalsIgnoreCase("int unsigned")) {
            return "int";
        }else if (sqlType.equalsIgnoreCase("bigint")) {
            return "long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        }else if (sqlType.equalsIgnoreCase("time")) {
            return "Time";
        }else if (sqlType.equalsIgnoreCase("date")) {
            return "Date";
        }

        return null;
    }

    /**
     * 出口
     * TODO
     *
     * @param args
     */
    public static void main(String[] args) {

        new GenEntityMysql();

    }

}