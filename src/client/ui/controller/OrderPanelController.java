package client.ui.controller;

import client.ui.model.OrderTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @Auther: Administrator
 * @Date: 2018/10/6 16:48
 * @Description:
 */
public class OrderPanelController {
    private JTable orderTable;
    private OrderTableModel orderTableModel;
    public OrderPanelController(JTable orderTable) {
        this.orderTable = orderTable;

        initCompoents(orderTable);
    }

    private void initCompoents(JTable orderTable) {
        // 初始化JTable model
        orderTableModel = new OrderTableModel();
        // 设置居中显示
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        orderTable.setDefaultRenderer(Object.class, tcr);//设置渲染器
        // 设置model
        orderTable.setModel(orderTableModel);
    }

    public OrderTableModel getOrderTableModel() {
        return orderTableModel;
    }

    public JTable getOrderTable() {
        return orderTable;
    }
}
