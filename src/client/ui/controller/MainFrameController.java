package client.ui.controller;

import client.ui.model.MusicTableModel;
import client.ui.view.MainFrame;
import client.ui.view.PlayBtnEditor;
import client.ui.view.PlayBtnRender;
import client.utils.TableColumnUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainFrameController {
    private MainFrame mainFrame;
    private JTable musicTable;
    private JComboBox musicComboBox;
    private JPanel mainPanel;

    private MusicTableModel musicTableModel;

    public MainFrameController() {
        // TODO 主界面 订单信息 个人信息
        initCompoents();
        initListeners();
    }

    private void initListeners() {
        // 歌曲类型下拉列表监听事件
        musicComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 状态已改变
                if (e.getStateChange() == 1) {
                    if (e.getItem() != "选择分类") {
                        musicTableModel.setMusicType(e.getItem().toString());
                        // 禁止选择一行
                        musicTable.setRowSelectionAllowed(false);
                        // 重绘列表
                        musicTable.validate();
                        musicTable.repaint();
                    }

                }
            }
        });
    }

    private void initCompoents() {
        mainFrame = new MainFrame();
        musicTable = mainFrame.getMusicTable();
        musicComboBox = mainFrame.getMusicComboBox();
        mainPanel = mainFrame.getMainPanel();
        // 初始化 JComboBox

        musicComboBox.addItem("选择分类");
        musicComboBox.addItem("流行");
        musicComboBox.addItem("摇滚");
        musicComboBox.addItem("民谣");
        musicComboBox.addItem("电子");

        // 初始化JTable model
        musicTableModel = new MusicTableModel();
        // 设置居中显示
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        musicTable.setDefaultRenderer(Object.class, tcr);//设置渲染器

        // 设置model
        musicTable.setModel(musicTableModel);
        // 设置列宽
        int[] width = new int[]{18, 75, 50, 75, 85, 60};
        musicTable.setColumnModel(TableColumnUtil.getColumn(musicTable, width));

        // 设置渲染器和监听器
        musicTable.getColumnModel().getColumn(0).setCellRenderer(new PlayBtnRender());
        musicTable.getColumnModel().getColumn(0).setCellEditor(new PlayBtnEditor());

        musicTable.getColumnModel().getColumn(5).setCellRenderer(new PlayBtnRender());
        musicTable.getColumnModel().getColumn(5).setCellEditor(new PlayBtnEditor());

    }


    public void showMainFrameWindow() {
        mainFrame.setVisible(true);
    }
}
