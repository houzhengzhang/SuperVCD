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
        loginUsernameTf = new JTextField();
        passwordLb = new JLabel();
        loginTxtPwd = new JPasswordField();
        down_panel = new JPanel();
        loginBtn = new JButton();
        noRegistLabel = new JLabel();
        userRegistePanel = new JPanel();
        label5 = new JLabel();
        label1 = new JLabel();
        registerUsernameTF = new JTextField();
        label3 = new JLabel();
        registTxtPwd = new JPasswordField();
        label4 = new JLabel();
        registAgainTxtPwd = new JPasswordField();
        buttonPanel = new JPanel();
        registerBtn = new JButton();
        resetBtn = new JButton();
        label6 = new JLabel();
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
                userPanel.setMaximumSize(new Dimension(450, 1000));
                userPanel.setVisible(false);
                userPanel.setOpaque(false);
                userPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)userPanel.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)userPanel.getLayout()).rowHeights = new int[] {241, 13, 280, 0, 0};
                ((GridBagLayout)userPanel.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)userPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //======== userLoginPanel ========
                {
                    userLoginPanel.setMaximumSize(new Dimension(460, 250));
                    userLoginPanel.setOpaque(false);
                    userLoginPanel.setMinimumSize(new Dimension(460, 227));
                    userLoginPanel.setLayout(new GridBagLayout());
                    ((GridBagLayout)userLoginPanel.getLayout()).columnWidths = new int[] {441, 0};
                    ((GridBagLayout)userLoginPanel.getLayout()).rowHeights = new int[] {36, 0, 14, 0, 125, 0};
                    ((GridBagLayout)userLoginPanel.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                    ((GridBagLayout)userLoginPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- label2 ----
                    label2.setText("superVCD \u7528\u6237\u767b\u5f55");
                    label2.setHorizontalAlignment(SwingConstants.CENTER);
                    label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                    userLoginPanel.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== up_panel ========
                    {
                        up_panel.setOpaque(false);
                        up_panel.setMaximumSize(new Dimension(460, 190));
                        up_panel.setMinimumSize(new Dimension(460, 80));
                        up_panel.setLayout(new MigLayout(
                            "hidemode 3",
                            // columns
                            "[93,fill]" +
                            "[113,fill]" +
                            "[100,fill]" +
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

                        //---- loginUsernameTf ----
                        loginUsernameTf.setBackground(new Color(143, 211, 196));
                        loginUsernameTf.setSelectedTextColor(Color.white);
                        loginUsernameTf.setMaximumSize(new Dimension(100, 24));
                        loginUsernameTf.setCaretColor(Color.white);
                        loginUsernameTf.setForeground(Color.white);
                        loginUsernameTf.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                        loginUsernameTf.setBorder(new RoundBorder());
                        loginUsernameTf.setOpaque(false);
                        loginUsernameTf.setMinimumSize(new Dimension(100, 24));
                        loginUsernameTf.setPreferredSize(new Dimension(100, 24));
                        up_panel.add(loginUsernameTf, "cell 2 0");

                        //---- passwordLb ----
                        passwordLb.setText("\u5bc6\u7801");
                        passwordLb.setHorizontalAlignment(SwingConstants.CENTER);
                        passwordLb.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                        passwordLb.setForeground(Color.white);
                        up_panel.add(passwordLb, "cell 1 1");

                        //---- loginTxtPwd ----
                        loginTxtPwd.setBorder(new RoundBorder());
                        loginTxtPwd.setMaximumSize(new Dimension(100, 24));
                        loginTxtPwd.setPreferredSize(new Dimension(120, 24));
                        loginTxtPwd.setMinimumSize(new Dimension(100, 24));
                        loginTxtPwd.setOpaque(false);
                        up_panel.add(loginTxtPwd, "cell 2 1");
                    }
                    userLoginPanel.add(up_panel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== down_panel ========
                    {
                        down_panel.setOpaque(false);
                        down_panel.setMaximumSize(new Dimension(172, 45));
                        down_panel.setMinimumSize(new Dimension(181, 45));
                        down_panel.setPreferredSize(new Dimension(351, 45));
                        down_panel.setLayout(new MigLayout(
                            "hidemode 3",
                            // columns
                            "[170,fill]" +
                            "[66,fill]" +
                            "[63,fill]",
                            // rows
                            "[39]0" +
                            "[20]"));

                        //---- loginBtn ----
                        loginBtn.setText("\u767b\u5f55");
                        loginBtn.setForeground(Color.black);
                        loginBtn.setMinimumSize(new Dimension(110, 30));
                        loginBtn.setMaximumSize(new Dimension(110, 30));
                        loginBtn.setHorizontalTextPosition(SwingConstants.CENTER);
                        down_panel.add(loginBtn, "cell 1 0 2 1");

                        //---- noRegistLabel ----
                        noRegistLabel.setText("\u6ca1\u6709\u5e10\u53f7\uff0c\u8bf7\u5148\u6ce8\u518c\uff01");
                        noRegistLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        down_panel.add(noRegistLabel, "cell 1 1 2 1");
                    }
                    userLoginPanel.add(down_panel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                userPanel.add(userLoginPanel, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== userRegistePanel ========
                {
                    userRegistePanel.setMaximumSize(new Dimension(450, 170));
                    userRegistePanel.setOpaque(false);
                    userRegistePanel.setLayout(new GridBagLayout());
                    ((GridBagLayout)userRegistePanel.getLayout()).columnWidths = new int[] {99, 121, 125, 0};
                    ((GridBagLayout)userRegistePanel.getLayout()).rowHeights = new int[] {27, 18, 37, 37, 37, 0, 0};
                    ((GridBagLayout)userRegistePanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)userRegistePanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- label5 ----
                    label5.setText("\u7528\u6237\u6ce8\u518c");
                    label5.setHorizontalAlignment(SwingConstants.CENTER);
                    label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                    userRegistePanel.add(label5, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label1 ----
                    label1.setText("\u7528\u6237\u540d");
                    label1.setHorizontalTextPosition(SwingConstants.CENTER);
                    label1.setHorizontalAlignment(SwingConstants.CENTER);
                    label1.setForeground(Color.white);
                    label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                    userRegistePanel.add(label1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- registerUsernameTF ----
                    registerUsernameTF.setOpaque(false);
                    registerUsernameTF.setBorder(new RoundBorder());
                    registerUsernameTF.setMaximumSize(new Dimension(100, 24));
                    registerUsernameTF.setMinimumSize(new Dimension(100, 24));
                    registerUsernameTF.setPreferredSize(new Dimension(100, 24));
                    userRegistePanel.add(registerUsernameTF, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label3 ----
                    label3.setText("\u5bc6\u7801");
                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                    label3.setForeground(Color.white);
                    label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                    userRegistePanel.add(label3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- registTxtPwd ----
                    registTxtPwd.setOpaque(false);
                    registTxtPwd.setBorder(new RoundBorder());
                    userRegistePanel.add(registTxtPwd, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- label4 ----
                    label4.setText("\u786e\u8ba4\u5bc6\u7801");
                    label4.setHorizontalAlignment(SwingConstants.CENTER);
                    label4.setForeground(Color.white);
                    label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
                    userRegistePanel.add(label4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- registAgainTxtPwd ----
                    registAgainTxtPwd.setOpaque(false);
                    registAgainTxtPwd.setBorder(new RoundBorder());
                    userRegistePanel.add(registAgainTxtPwd, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== buttonPanel ========
                    {
                        buttonPanel.setOpaque(false);
                        buttonPanel.setLayout(new GridBagLayout());
                        ((GridBagLayout)buttonPanel.getLayout()).columnWidths = new int[] {31, 84, 41, 76, 0};
                        ((GridBagLayout)buttonPanel.getLayout()).rowHeights = new int[] {0, 0, 0};
                        ((GridBagLayout)buttonPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                        ((GridBagLayout)buttonPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                        //---- registerBtn ----
                        registerBtn.setText("\u6ce8\u518c");
                        registerBtn.setPreferredSize(new Dimension(75, 30));
                        registerBtn.setMaximumSize(new Dimension(75, 30));
                        registerBtn.setMinimumSize(new Dimension(75, 30));
                        registerBtn.setForeground(Color.black);
                        buttonPanel.add(registerBtn, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- resetBtn ----
                        resetBtn.setText("\u91cd\u7f6e");
                        resetBtn.setForeground(Color.black);
                        buttonPanel.add(resetBtn, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    userRegistePanel.add(buttonPanel, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                userPanel.add(userRegistePanel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));

                //---- label6 ----
                label6.setText("text");
                label6.setIcon(new ImageIcon("D:\\JavaProject\\SuperVCD\\src\\resources\\5e37dca7ecd87ee1578ff433bd143b91.jpg"));
                userPanel.add(label6, new GridBagConstraints(0, 0, 1, 4, 0.0, 0.0,
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
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane loginTabbedPane;
    private JPanel userPanel;
    private JPanel userLoginPanel;
    private JLabel label2;
    private JPanel up_panel;
    private JLabel usernameLb;
    private JTextField loginUsernameTf;
    private JLabel passwordLb;
    private JPasswordField loginTxtPwd;
    private JPanel down_panel;
    private JButton loginBtn;
    private JLabel noRegistLabel;
    private JPanel userRegistePanel;
    private JLabel label5;
    private JLabel label1;
    private JTextField registerUsernameTF;
    private JLabel label3;
    private JPasswordField registTxtPwd;
    private JLabel label4;
    private JPasswordField registAgainTxtPwd;
    private JPanel buttonPanel;
    private JButton registerBtn;
    private JButton resetBtn;
    private JLabel label6;
    private JPanel adminPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JTextField getLoginUsernameTf() {
        return loginUsernameTf;
    }

    public JPasswordField getLoginTxtPwd() {
        return loginTxtPwd;
    }

    public JPanel getUserRegistePanel() {
        return userRegistePanel;
    }

    public JLabel getNoRegistLabel() {
        return noRegistLabel;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }

    public JButton getResetBtn() {
        return resetBtn;
    }

    public JTextField getRegisterUsernameTF() {
        return registerUsernameTF;
    }

    public JPasswordField getRegistTxtPwd() {
        return registTxtPwd;
    }

    public JPasswordField getRegistAgainTxtPwd() {
        return registAgainTxtPwd;
    }
}
