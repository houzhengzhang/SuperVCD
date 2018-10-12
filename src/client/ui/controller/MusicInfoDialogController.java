package client.ui.controller;

import client.client.MusicPlayer;
import client.client.SocketClient;
import client.ui.model.MusicTableModel;
import client.ui.view.MusicInfoDialog;
import client.ui.view.PlayBtnEditor;
import client.ui.view.PlayBtnRender;
import client.utils.TableColumnUtil;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: Administrator
 * @Date: 2018/10/5 09:52
 * @Description:
 */
public class MusicInfoDialogController {
    private MusicInfoDialog musicInfoDialog;
    private JFrame parentFrame;
    private JTable musicTable;

    private JLabel singerText;
    private JLabel albumText;
    private JLabel typeText;
    private JLabel lengthText;
    private JLabel priceText;

    private JLabel albumImage;
    private JTextArea infoTextArea;

    // 定义model
    private MusicTableModel musicTableModel;

    public MusicInfoDialogController(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initCompoents();
        initCloseListeners();
    }

    private void initCloseListeners() {
        musicInfoDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                MusicPlayer musicPlayer = MusicPlayer.getMusicPlayer();
                if (musicPlayer != null)
                    musicPlayer.stop();
            }
        });
    }


    private void initCompoents() {
        musicInfoDialog = new MusicInfoDialog(parentFrame);
        musicTable = musicInfoDialog.getMusicTable();
        // 获取label引用
        singerText = musicInfoDialog.getSingerText();
        albumText = musicInfoDialog.getAlbumText();
        typeText = musicInfoDialog.getTypeText();
        lengthText = musicInfoDialog.getLengthText();
        priceText = musicInfoDialog.getPriceText();
        infoTextArea = musicInfoDialog.getInfoTextArea();
        albumImage = musicInfoDialog.getAlbumImage();

        // 初始化JTable model
        musicTableModel = new MusicTableModel();
        // 设置model
        musicTable.setModel(musicTableModel);
        // 设置居中显示
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
        musicTable.setDefaultRenderer(Object.class, tcr);//设置渲染器
        // 设置列宽
        int[] width = new int[]{18, 90, 70};
        musicTable.setColumnModel(TableColumnUtil.getColumn(musicTable, width));

        // 设置渲染器和监听器
        musicTable.getColumnModel().getColumn(0).setCellRenderer(new PlayBtnRender());
        musicTable.getColumnModel().getColumn(0).setCellEditor(new PlayBtnEditor());

        // 隐藏音乐地址列
        TableColumnModel tcm = musicTable.getColumnModel();
        TableColumn tc = tcm.getColumn(3);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        tc.setWidth(0);
        tc.setMinWidth(0);
        musicTable.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        musicTable.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
    }

    private void setAlbumnId(int albumnId) {
        musicTableModel.setAlbumId(albumnId);
    }

    public void showDialog(String albumType, JSONObject singerJSON, JSONObject albumJSON) {
        // 设置当前专辑id
        setAlbumnId(albumJSON.getInt("id"));

        musicInfoDialog.setVisible(true);
        singerText.setText(singerJSON.getString("singerName"));
        albumText.setText(albumJSON.getString("albumName"));
        typeText.setText(albumType);
        lengthText.setText(musicTableModel.getAllMusicTime());
        priceText.setText(String.valueOf(albumJSON.getDouble("price")) + "￥");
        infoTextArea.setText(singerJSON.getString("singerInfo"));
        albumImage.setIcon(new ImageIcon(albumJSON.getString("imgUrl")));
    }

}
