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
public class OrderTableModel extends AbstractTableModel {
    private String[] columnNames = {"专辑名", "歌手", "价格"};
    // 获取客户端连接
    private SocketClient client = SocketClient.getSocketClient();
    private JSONArray items = null;

    public void setAlbumId(int albumId) {
        items = client.selectMusic(albumId);
    }

    public String getAllMusicTime(){
        String timeStr1 =  items.getJSONObject(0).getString("musicTime");
        for (int i = 1; i < items.length() ; i++) {
            String timeStr2 = items.getJSONObject(i).getString("musicTime");
            timeStr1 = DateTimeUtil.addTimeStr(timeStr1, timeStr2);
        }
        return timeStr1;

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
                return music.getString("musicUrl");
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。
        // TODO 按钮所在列返回True
        if (column == 0) {
            return true;
        } else {
            return false;
        }
    }
}