package client.ui.controller;

import client.ui.view.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainFrameController {
    private MainFrame mainFrame;
    private JTable musicTable;
    private JComboBox musicComboBox;

    private DefaultTableModel tableModel;

    public MainFrameController() {
        initCompoents();
        initListeners();
    }

    private void initListeners() {


        musicComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 状态已改变
                if (e.getStateChange() == 1) {
                    if (e.getItem() == "怀旧") {
                        tableModel.addRow(new Object[]{"山丘", "03:12", "李宗盛"});
                    } else if (e.getItem() == "浪漫") {
                        tableModel.addRow(new Object[]{"山丘2", "03:12", "李宗盛"});
                    } else if (e.getItem() == "清新") {
                        tableModel.addRow(new Object[]{"山丘3", "03:12", "李宗盛"});
                    }
                }
            }
        });
    }

    private void initCompoents() {
        mainFrame = new MainFrame();
        musicTable = mainFrame.getMusicTable();
        musicComboBox = mainFrame.getMusicComboBox();

        // 初始化 JComboBox

        musicComboBox.addItem("----");
        musicComboBox.addItem("怀旧");
        musicComboBox.addItem("浪漫");
        musicComboBox.addItem("清新");

        // 初始化JTable model
        Object[] columnNames = {"歌名", "时长", "歌手"};
        tableModel = new DefaultTableModel(columnNames, 0);
        musicTable.setModel(tableModel);

    }

    public void showMainFrameWindow() {
        mainFrame.setVisible(true);
    }
}
