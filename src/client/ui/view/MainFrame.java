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

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== topPanel ========
        {
            topPanel.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[72,fill]" +
                "[130,fill]" +
                "[124,fill]" +
                "[96,fill]",
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
        contentPane.add(topPanel, BorderLayout.NORTH);

        //======== mainPanel ========
        {
            mainPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)mainPanel.getLayout()).columnWidths = new int[] {84, 76, 75, 103, 55, 0};
            ((GridBagLayout)mainPanel.getLayout()).rowHeights = new int[] {25, 181, 0, 0};
            ((GridBagLayout)mainPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)mainPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //---- musicClassLabel ----
            musicClassLabel.setText("\u9009\u62e9\u97f3\u4e50\u7c7b\u522b");
            mainPanel.add(musicClassLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            mainPanel.add(musicComboBox, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- searchField ----
            searchField.setMinimumSize(new Dimension(64, 25));
            mainPanel.add(searchField, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- searchBtn ----
            searchBtn.setText("\u641c\u7d22");
            mainPanel.add(searchBtn, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== tableScrollPane ========
            {

                //---- musicTable ----
                musicTable.setModel(new DefaultTableModel());
                tableScrollPane.setViewportView(musicTable);
            }
            mainPanel.add(tableScrollPane, new GridBagConstraints(0, 1, 5, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        }
        contentPane.add(mainPanel, BorderLayout.CENTER);
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JTable getMusicTable() {
        return musicTable;
    }

    public JComboBox getMusicComboBox() {
        return musicComboBox;
    }
}
