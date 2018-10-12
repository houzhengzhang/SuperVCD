package client.ui.controller;

import client.client.SocketClient;
import client.ui.model.OrderTableModel;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Auther: Administrator
 * @Date: 2018/10/6 16:48
 * @Description:
 */
public class OrderPanelController {
    private JTable orderTable;
    private OrderTableModel orderTableModel;
    private JButton submitOrderBtn;

    // 记录当前用户
    private JSONObject userJSON;
    // 获取客户端连接
    private SocketClient client = SocketClient.getSocketClient();

    public OrderPanelController(JTable orderTable) {
        this.orderTable = orderTable;

        initCompoents();

    }

    private void initCompoents() {
        // 初始化JTable model
        orderTableModel = new OrderTableModel();
        // 设置居中显示
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        orderTable.setDefaultRenderer(Object.class, tcr);//设置渲染器
        // 设置model
        orderTable.setModel(orderTableModel);

        // 隐藏专辑id列
        TableColumnModel tcm = orderTable.getColumnModel();
        TableColumn tc = tcm.getColumn(3);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        tc.setWidth(0);
        tc.setMinWidth(0);
        orderTable.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        orderTable.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
    }

    public OrderTableModel getOrderTableModel() {
        return orderTableModel;
    }

    public JTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(JTable orderTable) {
        this.orderTable = orderTable;
    }

    public void setSubmitOrderBtn(JButton submitOrderBtn) {
        this.submitOrderBtn = submitOrderBtn;

        // 设置监听事件
        this.submitOrderBtn.addActionListener(new SubmitOrderBtnListener());
    }

    public void setUserJSON(JSONObject userJSON) {
        this.userJSON = userJSON;
    }

    /**
     * 提交按钮监听事件
     */
    private class SubmitOrderBtnListener implements ActionListener {
        private int row, col = 3;

        @Override
        public void actionPerformed(ActionEvent e) {
            row = orderTable.getRowCount();

            if (row <= 0) {
                JOptionPane.showMessageDialog(null, "请先购买专辑，再提交订单！");
                return;
            }
            // TODO 修改仅传userID
            int userId = userJSON.getInt("id");
            int[] albumIdArr = new int[row];
            for (int i = 0; i < row; i++) {
                albumIdArr[i] = (int) orderTable.getValueAt(i, col);
            }
            // TODO 修改接收数据格式
            JSONObject json = client.submitOrder(userId, albumIdArr);
            JOptionPane.showMessageDialog(null, json.getString("msg"), "提示", JOptionPane.WARNING_MESSAGE);

            // 清空订单
            orderTableModel.clearItem();
            orderTable.updateUI();
        }
    }


}
