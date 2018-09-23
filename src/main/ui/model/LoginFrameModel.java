package main.ui.model;

import main.dao.DbUtil;
import main.dao.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginFrameModel {

    public static List<UserInfo> searchUser() throws Exception{
        List<UserInfo> list = new ArrayList<UserInfo>();
        Connection conn = DbUtil.getCon();
        String sql = "select * from user_info";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //pstmt.setString(1, "user_info");

        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next())
        {
            UserInfo userInfo = new UserInfo(resultSet.getString("user_name"),
                    resultSet.getString("user_password"));

            list.add(userInfo);
        }

        return list;
    }
}
