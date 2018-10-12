/*
 * Created by JFormDesigner on Thu Sep 20 18:01:36 CST 2018
 */

package client.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import net.miginfocom.swing.*;

/**
 * @author jframe
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
        // 退出窗口
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        topPanel = new JPanel();
        topMenuBar = new JMenuBar();
        fileMenu = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        editMenu = new JMenu();
        menuItem7 = new JMenuItem();
        menu1 = new JMenu();
        tabbedPane1 = new JTabbedPane();
        musicPanel = new JPanel();
        musicClassLabel = new JLabel();
        musicComboBox = new JComboBox();
        tableScrollPane = new JScrollPane();
        albumTable = new JTable();
        textField1 = new JTextField();
        button1 = new JButton();
        orderPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        orderTable = new JTable();
        label1 = new JLabel();
        submitOrderBtn = new JButton();
        userPanel = new JPanel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== topPanel ========
        {
            topPanel.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[72,fill]" +
                "[130,fill]" +
                "[124,fill]" +
                "[172:178,fill]",
                // rows
                "[25,fill]" +
                "[4]"));

            //======== topMenuBar ========
            {

                //======== fileMenu ========
                {
                    fileMenu.setText("\u6587\u4ef6");
                    fileMenu.setPreferredSize(new Dimension(53, 21));
                    fileMenu.setMaximumSize(new Dimension(33, 32767));

                    //---- menuItem1 ----
                    menuItem1.setText("\u6253\u5f00");
                    fileMenu.add(menuItem1);

                    //---- menuItem2 ----
                    menuItem2.setText("\u4fdd\u5b58");
                    fileMenu.add(menuItem2);
                }
                topMenuBar.add(fileMenu);

                //======== editMenu ========
                {
                    editMenu.setText("\u9009\u9879");

                    //---- menuItem7 ----
                    menuItem7.setText("text");
                    editMenu.add(menuItem7);
                }
                topMenuBar.add(editMenu);

                //======== menu1 ========
                {
                    menu1.setText("\u5e2e\u52a9");
                }
                topMenuBar.add(menu1);
            }
            topPanel.add(topMenuBar, "cell 0 0 4 2");
        }
        contentPane.add(topPanel);
        topPanel.setBounds(0, 0, 523, 30);

        //======== tabbedPane1 ========
        {

            //======== musicPanel ========
            {
                musicPanel.setLayout(null);

                //---- musicClassLabel ----
                musicClassLabel.setText("\u9009\u62e9\u97f3\u4e50\u7c7b\u522b");
                musicPanel.add(musicClassLabel);
                musicClassLabel.setBounds(15, 10, 107, 29);
                musicPanel.add(musicComboBox);
                musicComboBox.setBounds(110, 10, 93, 29);

                //======== tableScrollPane ========
                {

                    //---- albumTable ----
                    albumTable.setModel(new DefaultTableModel());
                    tableScrollPane.setViewportView(albumTable);
                }
                musicPanel.add(tableScrollPane);
                tableScrollPane.setBounds(10, 45, 514, 203);
                musicPanel.add(textField1);
                textField1.setBounds(85, 260, 345, textField1.getPreferredSize().height);

                //---- button1 ----
                button1.setText("\u641c\u7d22");
                musicPanel.add(button1);
                button1.setBounds(new Rectangle(new Point(450, 260), button1.getPreferredSize()));

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < musicPanel.getComponentCount(); i++) {
                        Rectangle bounds = musicPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = musicPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    musicPanel.setMinimumSize(preferredSize);
                    musicPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u97f3\u4e50", musicPanel);

            //======== orderPanel ========
            {
                orderPanel.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(orderTable);
                }
                orderPanel.add(scrollPane1);
                scrollPane1.setBounds(20, 40, 470, 230);

                //---- label1 ----
                label1.setText("\u8ba2\u5355\u5185\u7684\u4e13\u8f91\u5217\u8868\uff1a");
                label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                orderPanel.add(label1);
                label1.setBounds(15, 10, 135, 22);

                //---- submitOrderBtn ----
                submitOrderBtn.setText("\u63d0\u4ea4\u8ba2\u5355");
                orderPanel.add(submitOrderBtn);
                submitOrderBtn.setBounds(new Rectangle(new Point(400, 290), submitOrderBtn.getPreferredSize()));

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < orderPanel.getComponentCount(); i++) {
                        Rectangle bounds = orderPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = orderPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    orderPanel.setMinimumSize(preferredSize);
                    orderPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u8ba2\u5355\u4fe1\u606f", orderPanel);

            //======== userPanel ========
            {
                userPanel.setLayout(null);

                //---- label2 ----
                label2.setText("\u5df2\u8d2d\u4e70\u4e13\u8f91\u5217\u8868\uff1a");
                userPanel.add(label2);
                label2.setBounds(20, 10, 240, 25);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(table1);
                }
                userPanel.add(scrollPane2);
                scrollPane2.setBounds(20, 40, 470, 190);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < userPanel.getComponentCount(); i++) {
                        Rectangle bounds = userPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = userPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    userPanel.setMinimumSize(preferredSize);
                    userPanel.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7528\u6237", userPanel);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 30, 580, 375);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel topPanel;
    private JMenuBar topMenuBar;
    private JMenu fileMenu;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu editMenu;
    private JMenuItem menuItem7;
    private JMenu menu1;
    private JTabbedPane tabbedPane1;
    private JPanel musicPanel;
    private JLabel musicClassLabel;
    private JComboBox musicComboBox;
    private JScrollPane tableScrollPane;
    private JTable albumTable;
    private JTextField textField1;
    private JButton button1;
    private JPanel orderPanel;
    private JScrollPane scrollPane1;
    private JTable orderTable;
    private JLabel label1;
    private JButton submitOrderBtn;
    private JPanel userPanel;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JTable getAlbumTable() {
        return albumTable;
    }

    public JComboBox getMusicComboBox() {
        return musicComboBox;
    }

    public JTable getOrderTable() {
        return orderTable;
    }

    public JButton getSubmitOrderBtn() {
        return submitOrderBtn;
    }
}
