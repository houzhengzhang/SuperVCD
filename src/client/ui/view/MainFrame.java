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
        mainPanel = new JPanel();
        musicClassLabel = new JLabel();
        musicComboBox = new JComboBox();
        searchField = new JTextField();
        searchBtn = new JButton();
        tableScrollPane = new JScrollPane();
        musicTable = new JTable();
        buttonPanel = new JPanel();
        button2 = new JButton();
        button1 = new JButton();
        button3 = new JButton();

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
            topPanel.add(topMenuBar, "cell 0 0 4 1");
        }
        contentPane.add(topPanel);
        topPanel.setBounds(0, 0, 523, topPanel.getPreferredSize().height);

        //======== mainPanel ========
        {
            mainPanel.setMaximumSize(new Dimension(475, 250));
            mainPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)mainPanel.getLayout()).columnWidths = new int[] {37, 84, 76, 75, 103, 55, 0};
            ((GridBagLayout)mainPanel.getLayout()).rowHeights = new int[] {25, 152, 0};
            ((GridBagLayout)mainPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)mainPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- musicClassLabel ----
            musicClassLabel.setText("\u9009\u62e9\u97f3\u4e50\u7c7b\u522b");
            mainPanel.add(musicClassLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            mainPanel.add(musicComboBox, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- searchField ----
            searchField.setMinimumSize(new Dimension(64, 25));
            mainPanel.add(searchField, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- searchBtn ----
            searchBtn.setText("\u641c\u7d22");
            mainPanel.add(searchBtn, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== tableScrollPane ========
            {

                //---- musicTable ----
                musicTable.setModel(new DefaultTableModel());
                tableScrollPane.setViewportView(musicTable);
            }
            mainPanel.add(tableScrollPane, new GridBagConstraints(1, 1, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(mainPanel);
        mainPanel.setBounds(0, 36, 523, 189);

        //======== buttonPanel ========
        {
            buttonPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)buttonPanel.getLayout()).columnWidths = new int[] {149, 129, 83, 0};
            ((GridBagLayout)buttonPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)buttonPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)buttonPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //---- button2 ----
            button2.setText("\u4e0a\u4e00\u9996");
            buttonPanel.add(button2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- button1 ----
            button1.setText("\u64ad\u653e");
            buttonPanel.add(button1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- button3 ----
            button3.setText("\u4e0b\u4e00\u9996");
            buttonPanel.add(button3, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        }
        contentPane.add(buttonPanel);
        buttonPanel.setBounds(-5, 250, 523, buttonPanel.getPreferredSize().height);

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
    private JPanel mainPanel;
    private JLabel musicClassLabel;
    private JComboBox musicComboBox;
    private JTextField searchField;
    private JButton searchBtn;
    private JScrollPane tableScrollPane;
    private JTable musicTable;
    private JPanel buttonPanel;
    private JButton button2;
    private JButton button1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JTable getMusicTable() {
        return musicTable;
    }

    public JComboBox getMusicComboBox() {
        return musicComboBox;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
