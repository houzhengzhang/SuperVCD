package client.ui.view;

import client.ui.model.OrderTableModel;

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

    // 记录按钮所在行的部分专辑信息 专辑名,歌手,价格,专辑id
    private int albumId;
    private String albumName;
    private String singerName;
    private String price;

    // TODO 定义位置？？？
    private OrderTableModel orderTableModel;
    private JTable orderTable;


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

                Object[] values = {albumName, singerName, price, albumId};
                if(orderTableModel.addOrderItem(values)){
                    // TODO 修改重绘调用位置
                    // 重绘订单列表
                    orderTable.updateUI();
                }else {
                    // 重复添加
                    JOptionPane.showMessageDialog(null, "该专辑已添加在订单列表，请勿重新添加！");
                }
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);

        button.setRow(row);
        button.setColumn(column);

        // 设置当前按钮对应的专辑信息
        albumId = (int) table.getValueAt(row, 6);
        albumName = (String) table.getValueAt(row, 0);
        singerName = (String) table.getValueAt(row, 1);
        price = (String) table.getValueAt(row, 4);

        return button;
    }


    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }


    public void setOrderTableModel(OrderTableModel orderTableModel) {
        this.orderTableModel = orderTableModel;
    }

    public void setOrderTable(JTable orderTable) {
        this.orderTable = orderTable;
    }
}
