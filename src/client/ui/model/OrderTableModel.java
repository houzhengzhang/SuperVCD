package client.ui.model;

import javax.swing.table.AbstractTableModel;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/10/3 09:12
 * @Description:
 */
public class OrderTableModel extends AbstractTableModel {
    private String[] columnNames = {"专辑名", "歌手", "价格", "album_id"};
    private List<Object[]> orderItems = new ArrayList<>();
//    private Map<Integer,String[]> orderItems;

    public boolean addOrderItem(Object[] values) {
        for (int i = 0; i < orderItems.size(); i++) {
            if (values[values.length - 1] == orderItems.get(i)[values.length - 1])
                return false;
        }
        orderItems.add(values);

        return true;
    }

    public void clearItem() {
        orderItems.clear();
    }


    @Override
    public int getRowCount() {
        if (orderItems == null)
            return 0;
        return orderItems.size();
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
        Object[] item = orderItems.get(rowIndex);
        switch (columnIndex) {
            case 0:
                // 专辑名
                return item[0];
            case 1:
                // 歌手
                return item[1];
            case 2:
                // 价格
                return item[2];
            // album_id
            case 3:
                return item[3];
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // 不可编辑
        return false;
    }
}