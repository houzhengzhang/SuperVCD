package server.model;

import server.dao.DbUtil;

import java.sql.Connection;

/**
 * @Auther: Administrator
 * @Date: 2018/10/12 14:19
 * @Description:
 */
public class OrderModel {

    public static int insert(int userId, int[] albumIdArr) {
        int num = 0;
        try {
            Connection conn = DbUtil.getCon();
            String sql = "insert into order_info(user_id, album_id) values(?,?)";
            for (int i = 0; i < albumIdArr.length; i++) {
                String[] param = {String.valueOf(userId), String.valueOf(albumIdArr[i])};
                num += DbUtil.executeUpdate(conn, sql, param);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }
}
