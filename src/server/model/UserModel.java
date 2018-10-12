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
        String sql = "select id,user_name,user_password from user_info where user_name=?";
        String[] param = {userName};
        ResultSet resultSet = DbUtil.executeQuery(conn, sql, param);
        List<UserInfo> userInfoList = ResultSetHandler.doHandler(resultSet, UserInfo.class);
        if (userInfoList.size() > 0)
            return userInfoList.get(0);
        else return null;
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
