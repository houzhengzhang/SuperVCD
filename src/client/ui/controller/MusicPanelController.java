package client.ui.controller;

import client.ui.model.AlbumTableModel;
import client.ui.model.OrderTableModel;
import client.ui.view.PurchaseBtnEditor;
import client.ui.view.PurchaseBtnRender;
import client.ui.view.PurchaseButton;
import client.utils.TableColumnUtil;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Auther: Administrator
 * @Date: 2018/10/6 16:48
 * @Description:
 */
public class MusicPanelController {
    private JFrame parentFrame;
    private JTable albumTable;
    private AlbumTableModel albumTableModel;

    // 定义购买按钮监听器
    private PurchaseBtnEditor purchaseBtnEditor;

    // 对话框控制器
    private MusicInfoDialogController musicInfoDialogController;

    public MusicPanelController(JFrame parentFrame, JTable albumTable) {
        this.albumTable = albumTable;
        this.parentFrame = parentFrame;
        // 初始化组件
        initCompoents();

        albumTable.addMouseListener(new MouseAdapter() {
            private int row,col;
            @Override
            public void mouseClicked(MouseEvent e) {
                row = albumTable.rowAtPoint(e.getPoint());
                col = albumTable.columnAtPoint(e.getPoint());
                System.out.println("row: " + row + "  col:" + col);
                if(col==0){
                    musicInfoDialogController.showDialog(albumTableModel.getAlbumType(), albumTableModel.getSingerItem(), albumTableModel.getAlbumAT(row));
                }

            }
        });
    }

    private void initCompoents() {
        // 初始化JTable model
        albumTableModel = new AlbumTableModel();
        // 设置居中显示
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        albumTable.setDefaultRenderer(Object.class, tcr);//设置渲染器

        // 设置model
        albumTable.setModel(albumTableModel);
        // 设置列宽
        int[] width = new int[]{110, 60, 85, 95, 60, 70};
        albumTable.setColumnModel(TableColumnUtil.getColumn(albumTable, width));

        // 初始化监听器
        purchaseBtnEditor = new PurchaseBtnEditor();
        // 设置渲染器和监听器
        albumTable.getColumnModel().getColumn(5).setCellRenderer(new PurchaseBtnRender());
        albumTable.getColumnModel().getColumn(5).setCellEditor(purchaseBtnEditor);

        // 隐藏专辑id列
        TableColumnModel tcm = albumTable.getColumnModel();
        TableColumn tc = tcm.getColumn(6);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        tc.setWidth(0);
        tc.setMinWidth(0);
        albumTable.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        albumTable.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);

        // 初始化专辑详细信息对话框控制器
        musicInfoDialogController = new MusicInfoDialogController(parentFrame);
    }

    public AlbumTableModel getAlbumTableModel() {
        return albumTableModel;
    }

    public void setOrderTable(JTable orderTable) {
        purchaseBtnEditor.setOrderTable(orderTable);
    }

    public void setOrderTableModel(OrderTableModel orderTableModel) {
        purchaseBtnEditor.setOrderTableModel(orderTableModel);
    }
}
