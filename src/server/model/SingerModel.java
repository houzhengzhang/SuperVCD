package server.model;

import server.dao.DbUtil;
import server.entity.SingerInfo;
import server.utils.ResultSetHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/9/30 13:24
 * @Description:
 */
public class SingerModel {
    /**
     * 根据id返回对应歌手
     * @param singerId
     * @return
     * @throws Exception
     */
    public static SingerInfo queryById(int singerId) throws Exception {
        // TODO 异常处理位置
        Connection conn = DbUtil.getCon();

        String sql = "select * from singer_info where id=?";
        String[] param = {singerId + ""};
        ResultSet resultSet = DbUtil.executeQuery(conn, sql, param);
        List<SingerInfo> singerInfoList = ResultSetHandler.doHandler(resultSet, SingerInfo.class);
        // TODO 结果集判空
        return singerInfoList.get(0);
    }

    public static void main(String[] args) {
        try {
            SingerInfo singerInfoList = queryById(1);
            System.out.println(singerInfoList.getSingerName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
