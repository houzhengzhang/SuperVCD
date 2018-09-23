/*
 * Created by JFormDesigner on Mon Sep 17 20:15:23 CST 2018
 */

package main.ui.view;

import java.awt.*;
import javax.swing.*;

import net.miginfocom.swing.*;

/**
 * @author jframe
 */
public class LoginFrame extends JFrame {
    public LoginFrame() {
        initComponents();
        // 退出窗口
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        loginTabbedPane = new JTabbedPane();
        userPanel = new JPanel();
        userLoginPanel = new JPanel();
        label2 = new JLabel();
        up_panel = new JPanel();
        usernameLb = new JLabel();
        usernameTf = new JTextField();
        passwordLb = new JLabel();
        txtPwd = new JPasswordField();
        down_panel = new JPanel();
        loginBtn = new JButton();
        registerBtn = new JButton();
        userRegistePanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        registerBtn2 = new JButton();
        resetBtn = new JButton();
        adminPanel = new JPanel();

        //======== this ========
        setTitle("Login");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== loginTabbedPane ========
        {
            loginTabbedPane.setMaximumSize(new Dimension(450, 557));

            //======== userPanel ========
            {
                userPanel.setMaximumSize(new Dimension(450, 525));
                userPanel.setVisible(false);
                userPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)userPanel.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)userPanel.getLayout()).rowHeights = new int[] {0, 53, 207, 0};
                ((GridBagLayout)userPanel.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)userPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                //======== userLoginPanel ========
                {
                    userLoginPanel.setLayout(new GridBagLayout());
                    ((GridBagLayout)userLoginPanel.getLayout()).columnWidths = new int[] {441, 0};
                    ((GridBagLayout)userLoginPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)userLoginPanel.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                    ((GridBagLayout)userLoginPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                    //---- label2 ----
                    label2.setText("superVCD \u7528\u6237\u767b\u5f55");
                    label2.setHorizontalAlignment(SwingConstants.CENTER);
                    userLoginPanel.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== up_panel ========
                    {
                        up_panel.setOpaque(false);
                        up_panel.setLayout(new MigLayout(
                            "hidemode 3",
                            // columns
                            "[69,fill]" +
                            "[160,fill]" +
                            "[134,fill]" +
                            "[76,fill]",
                            // rows
                            "0[39]" +
                            "[42]"));

                        //---- usernameLb ----
                        usernameLb.setText("\u7528\u6237\u540d");
                        usernameLb.setHorizontalAlignment(SwingConstants.CENTER);
                        usernameLb.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                        usernameLb.setForeground(Color.white);
                        up_panel.add(usernameLb, "cell 1 0");

                        //---- usernameTf ----
                        usernameTf.setBackground(new Color(143, 211, 196));
                        usernameTf.setSelectedTextColor(Color.white);
                        usernameTf.setMaximumSize(new Dimension(95, 40));
                        usernameTf.setCaretColor(Color.white);
                        usernameTf.setForeground(Color.white);
                        usernameTf.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                        usernameTf.setBorder(new RoundBorder());
                        usernameTf.setOpaque(false);
                        up_panel.add(usernameTf, "cell 2 0");

                        //---- passwordLb ----
                        passwordLb.setText("\u5bc6\u7801");
                        passwordLb.setHorizontalAlignment(SwingConstants.CENTER);
                        passwordLb.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                        passwordLb.setForeground(Color.white);
                        up_panel.add(passwordLb, "cell 1 1");
                        up_panel.add(txtPwd, "cell 2 1");
                    }
                    userLoginPanel.add(up_panel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== down_panel ========
                    {
                        down_panel.setOpaque(false);
                        down_panel.setMaximumSize(new Dimension(172, 45));
                        down_panel.setLayout(new MigLayout(
                            "hidemode 3",
                            // columns
                            "[70,fill]" +
                            "[132,fill]" +
                            "[119,fill]",
                            // rows
                            "[39]"));

                        //---- loginBtn ----
                        loginBtn.setText("\u767b\u5f55");
                        loginBtn.setForeground(Color.white);
                        down_panel.add(loginBtn, "cell 1 0");

                        //---- registerBtn ----
                        registerBtn.setText("\u6ce8\u518c");
                        registerBtn.setMaximumSize(new Dimension(66, 30));
                        down_panel.add(registerBtn, "cell 2 0");
                    }
                    userLoginPanel.add(down_panel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                userPanel.add(userLoginPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== userRegistePanel ========
                {
                    userRegistePanel.setVisible(false);
                    userRegistePanel.setLayout(new GridBagLayout());
                    ((GridBagLayout)userRegistePanel.getLayout()).columnWidths = new int[] {69, 163, 175, 0};
                    ((GridBagLayout)userRegistePanel.getLayout()).rowHeights = new int[] {45, 41, 0, 32, 0, 0};
                    ((GridBagLayout)userRegistePanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)userRegistePanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- label1 ----
                    label1.setText("\u7528\u6237\u540d");
                    label1.setHorizontalTextPosition(SwingConstants.CENTER);
                    label1.setHorizontalAlignment(SwingConstants.CENTER);
                    userRegistePanel.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                    userRegistePanel.add(textField1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label3 ----
                    label3.setText("\u5bc6\u7801");
                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                    userRegistePanel.add(label3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                    userRegistePanel.add(textField2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label4 ----
                    label4.setText("\u786e\u8ba4\u5bc6\u7801");
                    label4.setHorizontalAlignment(SwingConstants.CENTER);
                    userRegistePanel.add(label4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                    userRegistePanel.add(textField3, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- registerBtn2 ----
                    registerBtn2.setText("register");
                    userRegistePanel.add(registerBtn2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- resetBtn ----
                    resetBtn.setText("reset");
                    userRegistePanel.add(resetBtn, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                userPanel.add(userRegistePanel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            loginTabbedPane.addTab("\u7528\u6237\u767b\u5f55", userPanel);

            //======== adminPanel ========
            {
                adminPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)adminPanel.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)adminPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                ((GridBagLayout)adminPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)adminPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            }
            loginTabbedPane.addTab("\u7ba1\u7406\u5458\u767b\u5f55", adminPanel);
        }
        contentPane.add(loginTabbedPane, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane loginTabbedPane;
    private JPanel userPanel;
    private JPanel userLoginPanel;
    private JLabel label2;
    private JPanel up_panel;
    private JLabel usernameLb;
    private JTextField usernameTf;
    private JLabel passwordLb;
    private JPasswordField txtPwd;
    private JPanel down_panel;
    private JButton loginBtn;
    private JButton registerBtn;
    private JPanel userRegistePanel;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JButton registerBtn2;
    private JButton resetBtn;
    private JPanel adminPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }

    public JPasswordField getTxtPwd() {
        return txtPwd;
    }

    public JTextField getUsernameTf() {
        return usernameTf;
    }

    public JPanel getUserRegistePanel() {
        return userRegistePanel;
    }
}
