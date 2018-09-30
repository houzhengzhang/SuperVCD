package server.model;

import com.sun.org.glassfish.gmbal.Description;
import server.dao.DbUtil;
import server.entity.UserInfo;
import server.utils.ResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */
    public static List<UserInfo> queryAll() throws Exception {
        List<UserInfo> list = new ArrayList<UserInfo>();
        Connection conn = DbUtil.getCon();
        String sql = "select * from user_info";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //pstmt.setString(1, "user_info");

        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            UserInfo userInfo = new UserInfo(resultSet.getString("user_name"),
                    resultSet.getString("user_password"));

            list.add(userInfo);
        }

        return list;
    }


    public static ResultSet queryResult() throws Exception {
        List<UserInfo> list = new ArrayList<UserInfo>();
        Connection conn = DbUtil.getCon();
        String sql = "select * from user_info";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet resultSet = pstmt.executeQuery();

        return resultSet;
    }

    public static UserInfo queryByName(String userName) throws Exception {
        Connection conn = DbUtil.getCon();
        String sql = "select user_id,user_name,user_password from user_info where user_name=?";
        ResultSet resultSet = DbUtil.executeQuery(conn, sql, userName);
        UserInfo userInfo = null;
        if (resultSet.next()) {
            userInfo = new UserInfo(resultSet.getString("user_name"),
                    resultSet.getString("user_password"));
        }
        return userInfo;
    }


    public static int insert(String userName, String userPassword) {
        int num = 0;
        try {
            Connection conn = DbUtil.getCon();
            String sql = "insert into user_info(user_name,user_password) values(?,?)";
            String[] param = {userName, userPassword};
            num = DbUtil.executeUpdate(conn, sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }
}
