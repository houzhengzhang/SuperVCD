package client.ui.controller;

import client.client.SocketClient;
import client.ui.view.MainFrame;
import client.ui.view.MyButton;
import client.ui.view.ButtonEditor;
import client.ui.view.ButtonRender;
import client.utils.DateTimeUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import server.service.SocketService;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        musicTable.setColumnModel(getColumn(musicTable, width));

        musicTable.getColumnModel().getColumn(0).setCellRenderer(new ButtonRender());
        musicTable.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor());

        musicTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRender());
        musicTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor());

    }

    /**
     * 设置table 列宽
     * @param table
     * @param width
     * @return
     */
    public TableColumnModel getColumn(JTable table, int[] width) {
        TableColumnModel columns = table.getColumnModel();
        for (int i = 0; i < width.length; i++) {
            TableColumn column = columns.getColumn(i);
            column.setMinWidth(width[i]);
            column.setMaxWidth(width[i]);
            column.setPreferredWidth(width[i]);
        }
        return columns;
    }


    public void showMainFrameWindow() {
        mainFrame.setVisible(true);
    }

    private class MusicTableModel extends AbstractTableModel {
        private String[] columnNames = {"", "歌名", "时长", "歌手", "专辑", ""};
        private SocketClient client = SocketClient.getSocketClient();
        private JSONArray items = client.selectMusic("流行");

        public void setMusicType(String musicType) {
            items = client.selectMusic(musicType);
        }

        @Override
        public int getRowCount() {
            if (items == null)
                return 0;
            return items.length();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }


        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        // 当图形界面需要渲染第一个单元格的数据的时候，就会调用方法TabelModel的getValueAt(0,0) ，把返回值拿到并显示
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            JSONObject music = items.getJSONObject(rowIndex);
            switch (columnIndex) {
                case 1:
                    return music.getString("musicName");
                case 2:
                    return DateTimeUtil.strToTime(music.getString("musicTime"));
                case 3:
                    return music.getJSONObject("singer").getString("singerName");
                case 4:
                    return music.getJSONObject("album").getString("albumName");
                case 5:
                    return "购买";
            }
            return null;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // 带有按钮列的功能这里必须要返回true不然按钮点击时不会触发编辑效果，也就不会触发事件。
            // TODO 按钮所在列返回True
            if (column == 0) {
                return true;
            } else if (column == 5) {
                return true;
            } else {
                return false;
            }
        }
    }
}
