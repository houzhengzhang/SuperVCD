package client.ui.view;


import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 18:10
 * @Description:
 */
public class PurchaseBtnRender implements TableCellRenderer {
    private JPanel panel;
    private PurchaseButton button;

    public PurchaseBtnRender() {
        initButton();
        initPanel();
    }

    private void initButton() {
        // 设置按钮的大小及位置。
        button = new PurchaseButton("购买");
        // 在渲染器里边添加按钮的事件是不会触发的
        button.setBounds(0, 0, 70, 16);
    }


    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        // 只为按钮赋值即可。也可以作其它操作，如绘背景等。
        button.setText(value == null ? "" : String.valueOf(value));

        button.setRow(row);
        button.setColumn(column);

        return panel;
    }

    private void initPanel() {
        panel = new JPanel();
        // panel使用绝对定位，这样button就不会充满整个单元格
        panel.setLayout(null);
        panel.add(button);
        panel.setOpaque(false);
    }

}