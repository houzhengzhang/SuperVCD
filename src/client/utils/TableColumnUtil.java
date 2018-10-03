package client.utils;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @Auther: Administrator
 * @Date: 2018/10/3 09:17
 * @Description:
 */
public class TableColumnUtil {

    /**
     * 设置table 列宽
     *
     * @param table
     * @param width
     * @return
     */
    public static TableColumnModel getColumn(JTable table, int[] width) {
        TableColumnModel columns = table.getColumnModel();
        for (int i = 0; i < width.length; i++) {
            TableColumn column = columns.getColumn(i);
            column.setMinWidth(width[i]);
            column.setMaxWidth(width[i]);
            column.setPreferredWidth(width[i]);
        }
        return columns;
    }
}
