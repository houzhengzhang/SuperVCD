package client.ui.controller;

import client.client.SocketClient;
import client.ui.view.LoginFrame;
import client.utils.StateMsg;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
        initInputFilter();
    }

    /**
     * 初始化监听事件
     */
    private void initListeners() {

        // 没有注册请先注册事件
        noRegistLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loginFrame.setSize(440, 550);
                userRegistePanel.setVisible(true);
            }
        });
        // 重置按钮监听事件
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUsernameTF.setText("");
                registTxtPwd.setText("");
                registAgainTxtPwd.setText("");
            }
        });
        // 登录按钮监听事件
        loginBtn.addActionListener(new LoginBtnListener());

        // 注册按钮监听事件
        registerBtn.addActionListener(new RegisterBtnListener());
    }

    /**
     * 初始化输入框过滤
     */
    private void initInputFilter() {
        loginUsernameTf.setDocument(new InputUsernameFilter());
        registerUsernameTF.setDocument(new InputUsernameFilter());
    }

    public void showLoginFrameWindow() {
        loginFrame.setSize(440, 280);
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
            // 测试
            MainFrameController mainFrameController = new MainFrameController();
            mainFrameController.showMainFrameWindow();
            loginFrame.setVisible(false);

//            String username = loginUsernameTf.getText();
//            String password = String.valueOf(loginTxtPwd.getPassword());
//
//            try {
//                // TODO 这里不应该获取socket连接
//                SocketClient socketClient = SocketClient.getSocketClient();
//                // 向服务端发送数据
//                StateMsg msg = socketClient.login(username, password);
//                System.out.println("返回的消息：" + msg.toString());
//                switch (msg) {
//                    case LOGIN_SUCCESS_HINT:
//                        // 登录成功
//                        MainFrameController mainFrameController = new MainFrameController();
//                        mainFrameController.showMainFrameWindow();
//                        loginFrame.setVisible(false);
//                        break;
//                    case UNREGISTERED_HINT:
//                        // 该用户未注册
//                        JOptionPane.showMessageDialog(null, msg.getMsg(), "提示", JOptionPane.WARNING_MESSAGE);
//                        break;
//                    case PASSWORD_ERROR_HINT:
//                        // 密码错误
//                        JOptionPane.showMessageDialog(null, msg.getMsg(), "提示", JOptionPane.WARNING_MESSAGE);
//                        break;
//                }
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
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

            if (!password.equals(againPassword)) {
                JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入！", "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // 获取客户端 socket
            // TODO 这里不应该获取socket连接
            SocketClient socketClient = SocketClient.getSocketClient();
            // 向服务端发送数据
            StateMsg msg = socketClient.registe(username, password);
            System.out.println("返回的消息：" + msg.toString());
            switch (msg) {
                case REGISTERED_SUCCESS_HINT: {
                    JOptionPane.showMessageDialog(null, msg.getMsg(), "提示", JOptionPane.WARNING_MESSAGE);
                    loginFrame.setSize(450, 280);
                    userRegistePanel.setVisible(false);
                }
                case REGISTERED_ERROR_HINT: {
                    JOptionPane.showMessageDialog(null, msg.getMsg(), "提示", JOptionPane.WARNING_MESSAGE);
                }
            }


        }
    }

    /**
     * 用户名输入框限制
     */
    public class InputUsernameFilter extends PlainDocument {
        public final char[] ALLOW_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
                'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        private int length = 0;

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            boolean flag = false;
            for (char c : ALLOW_CHARS) {
                if (c == str.charAt(0)) {
                    flag = true;
                }
            }
            // 限制输入字符
            if (!flag)
                return;
            length += 1;
            // 限制最大长度为10
            if (length > 10)
                return;
            super.insertString(offs, str, a);
        }
    }

}

