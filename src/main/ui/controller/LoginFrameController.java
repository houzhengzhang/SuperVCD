package main.ui.controller;

import main.ui.view.LoginFrame;
import service.SocketClient;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginFrameController {
    private LoginFrame loginFrame;
    private JButton loginBtn;
    private JPanel userRegistePanel;
    private JLabel noRegistLabel;
    private JButton registerBtn;
    private JButton resetBtn;

    // 登录
    private JTextField loginUsernameTf;
    private JPasswordField loginTxtPwd;
    // 注册
    private JTextField registerUsernameTF;
    private JPasswordField registTxtPwd;
    private JPasswordField registAgainTxtPwd;

    public LoginFrameController() {
        initCompoents();
        initListeners();
    }

    private void initListeners() {
        // 没有注册请先注册事件
        noRegistLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loginFrame.setSize(450,550);
                userRegistePanel.setVisible(true);
            }
        });
        // 登录按钮监听事件
        loginBtn.addActionListener(new LoginBtnListener());

        // 注册按钮监听事件
        registerBtn.addActionListener(new RegisterBtnListener());
    }

    public void showLoginFrameWindow() {
        loginFrame.setSize(450, 280);
        loginFrame.setVisible(true);
    }

    private void initCompoents() {
        loginFrame = new LoginFrame();
        loginBtn = loginFrame.getLoginBtn();
        loginUsernameTf = loginFrame.getLoginUsernameTf();
        loginTxtPwd = loginFrame.getLoginTxtPwd();

        userRegistePanel = loginFrame.getUserRegistePanel();
        noRegistLabel = loginFrame.getNoRegistLabel();
        registerBtn = loginFrame.getRegisterBtn();
        resetBtn = loginFrame.getResetBtn();

        registerUsernameTF = loginFrame.getRegisterUsernameTF();
        registTxtPwd = loginFrame.getRegistTxtPwd();
        registAgainTxtPwd = loginFrame.getRegistAgainTxtPwd();
    }


    /**
     * 登录按钮监听事件
     */
    private class LoginBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginUsernameTf.getText();
            String password = String.valueOf(loginTxtPwd.getPassword());

            try {
                SocketClient socketClient = SocketClient.getSocketClient();
                // 向服务端发送数据
                // op 为0 登录
                socketClient.sendMessage(0, username, password);
                int receiveState = socketClient.receiveMessage();
                switch (receiveState) {
                    case 0:
                        // 登录成功
                        MainFrameController mainFrameController = new MainFrameController();
                        mainFrameController.showMainFrameWindow();
                        loginFrame.setVisible(false);
                        break;
                    case 1:
                        // 该用户未注册
                        JOptionPane.showMessageDialog(null, "该用户不存在，请先注册", "提示", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 2:
                        // 密码错误
                        JOptionPane.showMessageDialog(null, "密码错误，请重新输入", "提示", JOptionPane.WARNING_MESSAGE);
                        break;
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }


        }
    }


    /**
     * 注册按钮监听事件
     */
    private class RegisterBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = registerUsernameTF.getText();
            String password = String.valueOf(registTxtPwd.getPassword());
            String againPassword = String.valueOf(registAgainTxtPwd.getPassword());

            if(!password.equals(againPassword)){
                JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入！", "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // 获取客户端 socket
            SocketClient socketClient = SocketClient.getSocketClient();
            // 向服务端发送数据
            // op 为1 注册
            socketClient.sendMessage(1, username, password);


        }
    }
}
