package server.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class ResultSetHandler {

    /**
     * 将结果集映射到对象中
     * 1,遍历结果集
     * 2,遍历列名
     * 3,匹配对象中的属性
     *
     * @param rs
     * @param tClass
     * @param <T>
     * @return
     */

    public static <T> List<T> doHandler(ResultSet rs, Class<T> tClass) {
        List<T> list = new ArrayList<T>();

        // 是否启用驼峰命名法
        boolean isCamelCase = true;
        try {
            // 获取所有列名
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCount = rsMeta.getColumnCount();
            List<String> columnList = new ArrayList<String>();
            for (int i = 1; i <= columnCount; i++) {
                columnList.add(rsMeta.getColumnLabel(i));
            }
            // 获取类中所有属性(包括private)
            Field[] fields = tClass.getDeclaredFields();
            T obj = null;
            // 遍历结果集
            while (rs.next()) {
                obj = tClass.newInstance();
                // 匹配列名和属性名
                for (String columnName : columnList) {
                    // 列名转成小写
                    String cName = columnName.toLowerCase();
                    // 是否开启驼峰命名法
                    if (isCamelCase) {
                        cName = getCamelCase(columnName);
                    }

                    // 将value映射到属性中
                    for (Field f : fields) {
                        // 属性名称
                        String fName = f.getName();
                        if (cName.equals(fName)) {
                            // 方法名称
                            String mName = getSetMethod(fName);
                            // 字段类型
                            String fType = f.getType().getName();
                            // 获取SET方法
                            Method m = tClass.getMethod(mName, new Class[]{f.getType()});
                            if ("java.lang.Integer".equals(fType) || "int".equals(fType)) {
                                m.invoke(obj, rs.getInt(columnName));
                            } else if ("java.lang.Long".equals(fType) || "long".equals(fType)) {
                                m.invoke(obj, rs.getLong(columnName));
                            } else if ("java.lang.Float".equals(fType) || "float".equals(fType)) {
                                m.invoke(obj, rs.getFloat(columnName));
                            } else if ("java.lang.Double".equals(fType) || "double".equals(fType)) {
                                m.invoke(obj, rs.getDouble(columnName));
                            } else if ("java.lang.Boolean".equals(fType) || "boolean".equals(fType)) {
                                m.invoke(obj, rs.getBoolean(columnName)); // 自动转0-false,>0true
                            } else if ("java.lang.Shot".equals(fType) || "short".equals(fType)) {
                                m.invoke(obj, rs.getShort(columnName));
                            } else if ("java.lang.String".equals(fType)) {
                                m.invoke(obj, rs.getString(columnName));
                            } else if ("java.sql.Date".equals(fType)) {
                                m.invoke(obj, rs.getDate(columnName));
                            } else if ("java.sql.Timestamp".equals(fType) || "java.util.Date".equals(fType)) {
                                m.invoke(obj, rs.getTimestamp(columnName));
                            } else if ("java.math.BigDecimal".equals(fType)) {
                                m.invoke(obj, rs.getBigDecimal(columnName));
                            }else if("java.sql.Time".equals(fType)){
                                m.invoke(obj, rs.getTime(columnName));
                            }
                            continue;
                        }
                    }
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取驼峰命名法名称
     *
     * @param str
     * @return
     */
    private static String getCamelCase(String str) {

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
     * 获取set方法
     *
     * @param str
     * @return
     */
    private static String getSetMethod(String str) {
        return "set" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
