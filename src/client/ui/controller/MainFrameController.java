package client.ui.controller;

import client.ui.model.AlbumTableModel;
import client.ui.view.MainFrame;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrameController {
    private MainFrame mainFrame;
    private JTable orderTable;
    private JTable albumTable;
    private JButton submitOrderBtn;
    private JComboBox musicComboBox;

    private AlbumTableModel albumTableModel;

    // 定义子控制器
    private OrderPanelController orderPanelController;
    private MusicPanelController musicPanelController;


    public MainFrameController() {
        // TODO 主界面 订单信息 个人信息
        initCompoents();
        initListeners();
        initController();

    }

    private void initController() {
        // 订单控制器
        orderPanelController = new OrderPanelController(orderTable);
        orderPanelController.setSubmitOrder(submitOrderBtn);

        // 将table引用传给子控制器
        orderPanelController.setOrderTable(orderTable);

        // 专辑控制器
        musicPanelController = new MusicPanelController(mainFrame, albumTable);

        // 将table引用传给子控制器
        musicPanelController.setOrderTable(orderTable);

        // 获取 albumTableModel
        albumTableModel = musicPanelController.getAlbumTableModel();

        // TODO 修改设置位置
        musicPanelController.setOrderTableModel(orderPanelController.getOrderTableModel());

    }

    private void initListeners() {
        // 歌曲类型下拉列表监听事件
        musicComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 状态已改变
                if (e.getStateChange() == 1) {
                    if (e.getItem() != "选择分类") {
                        albumTableModel.setMusicType(e.getItem().toString());
                        // 禁止选择一行
                        albumTable.setRowSelectionAllowed(false);
                        // 重绘列表
                        albumTable.updateUI();
                    }
                }
            }
        });
    }

    private void initCompoents() {
        mainFrame = new MainFrame();
        albumTable = mainFrame.getAlbumTable();
        orderTable = mainFrame.getOrderTable();
        musicComboBox = mainFrame.getMusicComboBox();
        submitOrderBtn = mainFrame.getSubmitOrderBtn();

        // 初始化 JComboBox
        musicComboBox.addItem("选择分类");
        musicComboBox.addItem("流行");
        musicComboBox.addItem("摇滚");
        musicComboBox.addItem("民谣");
        musicComboBox.addItem("电子");


    }

    /**
     * 显示窗口
     */
    public void showMainFrameWindow() {
        mainFrame.setVisible(true);
    }

    public void setUserJSON(JSONObject userJSON) {
        // TODO 记录用户信息
        orderPanelController.setUserJSON(userJSON);
    }
}
