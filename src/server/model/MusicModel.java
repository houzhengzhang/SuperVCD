package server.model;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import server.dao.DbUtil;
import server.entity.MusicInfo;
import server.entity.SingerInfo;
import server.utils.ResultSetHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/9/29 21:29
 * @Description:
 */
public class MusicModel {

    public static List<MusicInfo> queryByType(String typeName) throws Exception {
        // TODO 异常处理的位置
        Connection conn = DbUtil.getCon();

        String sql = "select * from music_info where type_id=(select id from music_type where type_name=?)";
        String[] param = {typeName};
        ResultSet resultSet = DbUtil.executeQuery(conn, sql, param);
        List<MusicInfo> musicInfoList = ResultSetHandler.doHandler(resultSet, MusicInfo.class);
        // TODO 判断结果为空
        return musicInfoList;
    }

    public static void main(String[] args) {
        try {
            List<MusicInfo> musicInfoList = queryByType("流行");
            for (MusicInfo musicInfo : musicInfoList) {
                SingerInfo singerInfo = SingerModel.queryById(musicInfo.getSingerId());

                System.out.println("歌名： " + musicInfo.getMusicName() + " 时长：" + musicInfo.getMusicTime() + "  歌手：" + singerInfo.getSingerName() );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
