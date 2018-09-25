package main.ui.model;

import main.dao.DbUtil;
import main.dao.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginFrameModel {

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

    public static UserInfo queryByName(String userName) throws Exception {
        Connection conn = DbUtil.getCon();
        String sql = "select user_id,user_name,user_password from user_info where user_name=?";
        ResultSet resultSet = DbUtil.executQuery(conn, sql, userName);
        System.out.println(resultSet);
        if (resultSet.next()) {
            UserInfo userInfo = new UserInfo(resultSet.getString("user_name"),
                    resultSet.getString("user_password"));
            System.out.println(resultSet);
            return userInfo;
        } else {
            System.out.println("it is null");
            return null;
        }
    }
}
