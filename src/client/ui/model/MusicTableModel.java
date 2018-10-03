package client.ui.model;

import client.client.SocketClient;
import client.utils.DateTimeUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.table.AbstractTableModel;

/**
 * @Auther: Administrator
 * @Date: 2018/10/3 09:12
 * @Description:
 */
public class MusicTableModel extends AbstractTableModel {
    private String[] columnNames = {"", "歌名", "时长", "歌手", "专辑", ""};
    // 获取客户端连接
    private SocketClient client = SocketClient.getSocketClient();
    private JSONArray items = client.selectMusic("摇滚");

    public void setMusicType(String musicType) {
        items = client.selectMusic(musicType);
    }

    @Override
    public int getRowCount() {
        if (items == null)
            return 0;
        return items.length();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }


    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    // 当图形界面需要渲染第一个单元格的数据的时候，就会调用方法TabelModel的getValueAt(0,0) ，把返回值拿到并显示
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JSONObject music = items.getJSONObject(rowIndex);
        switch (columnIndex) {
            case 1:
                return music.getString("musicName");
            case 2:
                return DateTimeUtil.strToTime(music.getString("musicTime"));
            case 3:
                return music.getJSONObject("singer").getString("singerName");
            case 4:
                return music.getJSONObject("album").getString("albumName");
            case 5:
                return "购买";
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。
        // TODO 按钮所在列返回True
        if (column == 0) {
            return true;
        } else if (column == 5) {
            return true;
        } else {
            return false;
        }
    }
}