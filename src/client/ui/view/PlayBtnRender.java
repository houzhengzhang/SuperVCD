package client.ui.view;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 18:10
 * @Description:
 */
public class PlayBtnRender implements TableCellRenderer {
    private JPanel panel;
    private MyButton button;

    public PlayBtnRender() {
        initButton();
        initPanel();
    }

    private void initButton() {
        // 设置按钮的大小及位置。
        button = new MyButton("播放", new ImageIcon("D:\\JavaProject\\SuperVCD\\src\\client\\resources\\播放.png"));
        button.setRolloverIcon(new ImageIcon("D:\\JavaProject\\SuperVCD\\src\\client\\resources\\播放2.png"));
        button.setOpaque(false);
        button.setBounds(0, 0, 18, 15);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        // 在渲染器里边添加按钮的事件是不会触发的
    }


    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        // System.out.println("render selected: " + isSelected + "focused: " + hasFocus) ;
        if (hasFocus) {
            button.setIcon(new ImageIcon("D:\\JavaProject\\SuperVCD\\src\\client\\resources\\播放2.png"));
        } else {
            button.setIcon(new ImageIcon("D:\\JavaProject\\SuperVCD\\src\\client\\resources\\播放.png"));
        }
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