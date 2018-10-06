package client.ui.controller;

import client.ui.model.AlbumTableModel;
import client.ui.view.MainFrame;
import client.ui.view.PlayBtnEditor;
import client.ui.view.PlayBtnRender;
import client.ui.view.PurchaseBtnEditor;
import client.ui.view.PurchaseBtnRender;
import client.utils.TableColumnUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrameController {
    private MainFrame mainFrame;
    private JTable orderTable;
    private JTable albumTable;
    private JComboBox musicComboBox;
    private AlbumTableModel albumTableModel;

    // 定义子控制器
    private OrderPanelController orderPanelController;

    client.ui.controller.MusicInfoDialogController musicInfoDialogController;

    public MainFrameController() {
        // TODO 主界面 订单信息 个人信息
        initCompoents();
        initListeners();

        initController();
    }

    private void initController() {
        orderPanelController = new OrderPanelController(orderTable);
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

        albumTable.addMouseListener(new MouseAdapter() {
            private int row,col;
            @Override
            public void mouseClicked(MouseEvent arg0) {
                // TODO Auto-generated method stub
                col = albumTable.columnAtPoint(arg0.getPoint());
                row = albumTable.rowAtPoint(arg0.getPoint());
                if (arg0.getClickCount() == 2 && col == 0) {
                   musicInfoDialogController.showDialog(albumTableModel.getAlbumType(), albumTableModel.getSingerItem(),albumTableModel.getAlbumAT(row));
                }
            }

        });
    }

    private void initCompoents() {
        mainFrame = new MainFrame();
        albumTable = mainFrame.getAlbumTable();
        orderTable = mainFrame.getOrderTable();
        musicComboBox = mainFrame.getMusicComboBox();
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
        int[] width = new int[]{110, 60, 85, 95, 70};
        albumTable.setColumnModel(TableColumnUtil.getColumn(albumTable, width));

        // 设置渲染器和监听器
        albumTable.getColumnModel().getColumn(4).setCellRenderer(new PurchaseBtnRender());
        albumTable.getColumnModel().getColumn(4).setCellEditor(new PurchaseBtnEditor());

        // 隐藏专辑id列
        TableColumnModel tcm = albumTable.getColumnModel();
        TableColumn tc = tcm.getColumn(5);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        tc.setWidth(0);
        tc.setMinWidth(0);
        albumTable.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        albumTable.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);


        // 初始化专辑详细信息对话框控制器
        musicInfoDialogController =  new client.ui.controller.MusicInfoDialogController(mainFrame);

    }


    public void showMainFrameWindow() {
        mainFrame.setVisible(true);
    }
}
