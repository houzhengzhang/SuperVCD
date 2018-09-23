package main.dao;

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

    /**
     * 获取连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getCon() throws Exception {
        Class.forName(driver);
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
     * @param conn
     * @param sql
     * @param param
     * @return
     */
    public static ResultSet executQuery(Connection conn, String sql, String[] param) {
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

}