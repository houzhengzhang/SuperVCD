package client.ui.controller;

import client.ui.model.AlbumTableModel;
import client.ui.view.MainFrame;
import client.ui.view.PlayBtnEditor;
import client.ui.view.PlayBtnRender;
import client.utils.TableColumnUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrameController {
    private MainFrame mainFrame;
    private JTable albumTable;
    private JComboBox musicComboBox;
    private JPanel mainPanel;
    private JScrollPane tableScrollPane;

    private AlbumTableModel albumTableModel;

    MusicInfoDialogController musicInfoDialogController;

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
                        albumTableModel.setMusicType(e.getItem().toString());
                        // 禁止选择一行
                        albumTable.setRowSelectionAllowed(false);
                        // 重绘列表
                        albumTable.updateUI();
                        //tableScrollPane.validate();
                    }

                }
            }
        });

        albumTable.addMouseListener(new MouseAdapter() {
            private int row,col;
            private String albumName;
            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                col = albumTable.columnAtPoint(arg0.getPoint());
                row = albumTable.rowAtPoint(arg0.getPoint());
                albumName = (String) albumTable.getValueAt(row,col);
                if (arg0.getClickCount() == 2 && col == 1) {
                   musicInfoDialogController.showDialog(albumTableModel.getAlbumType(), albumTableModel.getSingerItem(),albumTableModel.getAlbumAT(row));
                }
            }

        });
    }

    private void initCompoents() {
        mainFrame = new MainFrame();
        albumTable = mainFrame.getAlbumTable();
        musicComboBox = mainFrame.getMusicComboBox();
        mainPanel = mainFrame.getMainPanel();
        tableScrollPane = mainFrame.getTableScrollPane();
        // 初始化 JComboBox

        musicComboBox.addItem("选择分类");
        musicComboBox.addItem("流行");
        musicComboBox.addItem("摇滚");
        musicComboBox.addItem("民谣");
        musicComboBox.addItem("电子");

        // 初始化JTable model
        albumTableModel = new AlbumTableModel();
        // 设置居中显示
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        albumTable.setDefaultRenderer(Object.class, tcr);//设置渲染器

        // 设置model
        albumTable.setModel(albumTableModel);
        // 设置列宽
        int[] width = new int[]{18, 75, 50, 75, 85, 60};
        albumTable.setColumnModel(TableColumnUtil.getColumn(albumTable, width));

        // 设置渲染器和监听器
        albumTable.getColumnModel().getColumn(0).setCellRenderer(new PlayBtnRender());
        albumTable.getColumnModel().getColumn(0).setCellEditor(new PlayBtnEditor());

//        albumTable.getColumnModel().getColumn(5).setCellRenderer(new PlayBtnRender());
//        albumTable.getColumnModel().getColumn(5).setCellEditor(new PlayBtnEditor());

        // 初始化专辑详细信息对话框控制器
        musicInfoDialogController =  new MusicInfoDialogController(mainFrame);

    }


    public void showMainFrameWindow() {
        mainFrame.setVisible(true);
    }
}
