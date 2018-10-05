package client.ui.model;

import client.client.SocketClient;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.table.AbstractTableModel;

/**
 * @Auther: Administrator
 * @Date: 2018/10/3 09:12
 * @Description:
 */
public class AlbumTableModel extends AbstractTableModel {
    private String[] columnNames = {"", "专辑名", "歌手", "出版公司", "出版时间", ""};
    // 获取客户端连接
    private SocketClient client = SocketClient.getSocketClient();
    private JSONArray albumItems = null;
    private String albumType;
    private JSONObject singerItem;

    public void setMusicType(String albumType) {
        this.albumType = albumType;
        albumItems = client.selectAlbum(albumType);
        singerItem = client.selectSinger(albumItems.getJSONObject(0).getInt("id"));
    }


    public JSONObject getAlbumAT(int row) {
        return albumItems.getJSONObject(row);
    }

    public String getAlbumType() {
        return albumType;
    }


    public JSONObject getSingerItem() {
        return singerItem;
    }

    @Override
    public int getRowCount() {
        if (albumItems == null)
            return 0;
        return albumItems.length();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    // 当图形界面需要渲染第一个单元格的数据的时候，就会调用方法TabelModel的getValueAt(0,0) ，把返回值拿到并显示
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JSONObject album = albumItems.getJSONObject(rowIndex);
        switch (columnIndex) {
            case 1:
                return album.getString("albumName");
            case 2:
                return singerItem.getString("singerName");
            case 3:
                return album.getString("publicCompany");
            case 4:
                return album.getString("publicDate");
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