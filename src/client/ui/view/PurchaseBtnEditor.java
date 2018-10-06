package client.ui.view;

import client.client.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 18:25
 * @Description:
 */
public class PurchaseBtnEditor extends DefaultCellEditor {
    protected PurchaseButton button;
    private JPanel panel;
    private String label;


    public PurchaseBtnEditor() {
        // DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。
        super(new JCheckBox());
        // 设置点击几次激活编辑。
        setClickCountToStart(1);
        initButton();
        initPanel();
        initListeners();
    }

    private void initPanel() {
        panel = new JPanel();
        // panel使用绝对定位，这样button就不会充满整个单元格
        panel.setLayout(null);
        panel.add(button);
        panel.setOpaque(false);
    }

    private void initButton() {
        button = new PurchaseButton("播放");
    }

    private void initListeners() {
        // 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。
        button.addActionListener(new ActionListener() {
            private PurchaseButton button;

            public void actionPerformed(ActionEvent e) {
                // 触发取消编辑的事件，不会调用tableModel的setValue方法。
                // TODO 通过以下代码解决按钮事件更新不及时问题
                fireEditingCanceled();

                button = (PurchaseButton) e.getSource();
                System.out.println("album id :" + button.getAlbumId());

            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);

        button.setRow(row);
        button.setColumn(column);
        // 设置当前按钮对应的专辑id
        int albumId = (int) table.getValueAt(row, 5);
        button.setAlbumId(albumId);
        return button;
    }


    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }
}
