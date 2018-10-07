package client.ui.model;

import client.client.SocketClient;
import client.utils.DateTimeUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/10/3 09:12
 * @Description:
 */
public class OrderTableModel extends AbstractTableModel {
    private String[] columnNames = {"专辑名", "歌手", "价格"};
    // 获取客户端连接
    private SocketClient client = SocketClient.getSocketClient();
    private List<String[]> items = new ArrayList<>();

    public void setAlbumId(String[] values) {
        items.add(values);
    }

    @Override
    public int getRowCount() {
        if (items == null)
            return 0;
        return items.size();
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
        String[] music = items.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return music[1];
            case 1:
                return music[2];
            case 2:
                return music[3];
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