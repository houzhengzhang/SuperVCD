package client.ui.view;

import client.client.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 18:25
 * @Description:
 */
public class PlayBtnEditor extends DefaultCellEditor {
    protected PlayButton button;
    private JPanel panel;
    private String label;

    private boolean isPushed;

    public PlayBtnEditor() {
        // DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。
        super(new JCheckBox());
        // 设置点击几次激活编辑。
        setClickCountToStart(1);
        initButton();
        initPanel();
        initListeners();
    }

    private void initPanel() {
        panel = new JPanel();
        // panel使用绝对定位，这样button就不会充满整个单元格
        panel.setLayout(null);
        panel.add(button);
        panel.setOpaque(false);
    }

    private void initButton() {
        button = new PlayButton("播放");
        button.setOpaque(false);
        // 设置按钮的大小及位置。
        button.setBounds(0, 0, 18, 16);
    }

    private void initListeners() {
        // 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。
        button.addActionListener(new ActionListener() {
            private boolean play = false;
            private MusicPlayer player = null;
            private int row = -1;
            private String musicUrl;
            private PlayButton button;

            public void actionPerformed(ActionEvent e) {
                button = (PlayButton) e.getSource();
                //打印被点击的行和列
//                System.out.println("test   -row:" + button.getRow() + "column :" + button.getColumn());
//                // 触发取消编辑的事件，不会调用tableModel的setValue方法。
                PlayBtnEditor.this.fireEditingCanceled();

                if (row == button.getRow()) {
                        if (play) {
                            player.pause();
                            play = false;
                        } else {
                            player.continues();
                            play = true;
                        }
                }else {
                    // 点击其他行
                    row = button.getRow();
                    musicUrl = button.getMusicUrl();
                    player = MusicPlayer.getMusicPlayer(musicUrl);
                    player.start(false);
                }

            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        // System.out.println("editor selected: " + isSelected);
        if (isSelected) {
            button.setIcon(new ImageIcon("D:\\JavaProject\\SuperVCD\\src\\client\\resources\\播放2.png"));
        } else {
            button.setIcon(new ImageIcon("D:\\JavaProject\\SuperVCD\\src\\client\\resources\\播放.png"));
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;

        button.setRow(row);
        button.setColumn(column);
        // 设置当前按钮对应的歌曲地址
        String musicUrl = (String) table.getValueAt(row, 3);
        button.setMusicUrl(musicUrl);

        return button;
    }


    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
