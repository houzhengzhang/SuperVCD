package server.model;

import server.dao.DbUtil;
import server.entity.AlbumInfo;
import server.utils.ResultSetHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 09:39
 * @Description:
 */
public class AlbumModel {

    public static AlbumInfo queryById(int albumId) throws Exception {
        Connection conn = DbUtil.getCon();
        String sql = "select * from album_info where id=?";
        String[] param = {albumId + ""};
        ResultSet resultSet = DbUtil.executeQuery(conn, sql, param);
        List<AlbumInfo> albumInfoList = ResultSetHandler.doHandler(resultSet, AlbumInfo.class);
        return albumInfoList.get(0);
    }
}
