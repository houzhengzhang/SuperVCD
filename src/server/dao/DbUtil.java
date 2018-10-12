package server.dao;

import java.sql.*;

/**
 * Created by qcl on 2017/11/18.
 * 数据库连接
 */
public class DbUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/super_vcd";
    private static String user = "root";
    private static String password = "123456";

    // 由于驱动程序不经常改变，将其放在静态代码块中，只在类加载的时候加载一次
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getCon() throws Exception {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 关闭连接
     *
     * @param preparedStatement
     * @param conn
     * @throws SQLException
     */
    public static void close(PreparedStatement preparedStatement, Connection conn) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
            if (conn != null) {
                conn.close();
            }
        }
    }

    /**
     * 执行查询
     *
     * @param conn
     * @param sql
     * @param param
     * @return
     */
    public static ResultSet executeQuery(Connection conn, String sql, String[] param) {
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setString(i + 1, param[i]);
                }
                result = pstmt.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 执行更新操作(新增、修改、删除)
     *
     * @param conn
     * @param sql
     * @param param
     * @return
     */
    public static int executeUpdate(Connection conn, String sql, String[] param) {
        PreparedStatement pstmt = null;
        // 受影响记录条数
        int num = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setString(i + 1, param[i]);
                }
                num = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            num = 0;
        }
        return num;

    }


}