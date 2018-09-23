package main.ui.controller;

import main.ui.view.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrameController {
    private MainFrame mainFrame;
    private JTable musicTable;
    private JComboBox musicComboBox;

    public MainFrameController() {
        initCompoents();
    }

    private void initCompoents() {
        mainFrame = new MainFrame();
        musicTable = mainFrame.getMusicTable();
        musicComboBox = mainFrame.getMusicComboBox();
        musicComboBox.addItem("怀旧");
        musicComboBox.addItem("浪漫");
        musicComboBox.addItem("清新");
        // 表头（列名）
        Object[] columnNames = {"姓名", "语文", "数学", "英语", "总分"};

        // 表格所有行数据
        Object[][] rowData = {
                {"张三", 80, 80, 80, 240},
                {"John", 70, 80, 90, 240},
                {"Sue", 70, 70, 70, 210},
                {"Jane", 80, 70, 60, 210},
                {"Joe", 80, 70, 60, 210},
                {"张三", 80, 80, 80, 240},
                {"John", 70, 80, 90, 240},
                {"Sue", 70, 70, 70, 210},
                {"Jane", 80, 70, 60, 210},
                {"Joe", 80, 70, 60, 210},
        };

        musicTable.setModel(new DefaultTableModel(rowData, columnNames));

    }

    public void showMainFrameWindow(){mainFrame.setVisible(true);}
}
