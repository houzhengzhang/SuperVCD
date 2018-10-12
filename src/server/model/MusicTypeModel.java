package server.model;

import server.dao.DbUtil;
import server.entity.MusicType;
import server.utils.ResultSetHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 09:39
 * @Description:
 */
public class MusicTypeModel {

    public static List<MusicType> queryAllType() throws Exception {
        Connection conn = DbUtil.getCon();
        String sql = "select * from music_type";
        String[] param = {};
        ResultSet resultSet = DbUtil.executeQuery(conn, sql, param);

        List<MusicType>  musicTypeList= ResultSetHandler.doHandler(resultSet, MusicType.class);
        return musicTypeList;
    }
}
