package main.ui.controller;

import main.dao.UserInfo;
import main.ui.model.LoginFrameModel;
import main.ui.view.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginFrameController {
    private LoginFrame loginFrame;
    private JButton loginBtn;
    private JButton registerBtn;
    private JTextField usernameTf;
    private JPasswordField txtPwd;
    private JPanel userRegistePanel;

    private String username;
    private String password;

    public LoginFrameController() {
        initCompoents();
        initListeners();
    }

    private void initListeners() {
        registerBtn.addActionListener(new RegisterBtnListener());
        loginBtn.addActionListener(new LoginBtnListener());
    }

    public void showLoginFrameWindow() {
        loginFrame.setSize(420,200);
        loginFrame.setVisible(true);
    }

    private void initCompoents() {
        loginFrame = new LoginFrame();
        loginBtn = loginFrame.getLoginBtn();
        registerBtn = loginFrame.getRegisterBtn();
        usernameTf = loginFrame.getUsernameTf();
        txtPwd = loginFrame.getTxtPwd();
        userRegistePanel = loginFrame.getUserRegistePanel();
    }

    private class RegisterBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            RegisterFrameController registerFrameController = new RegisterFrameController();
//            registerFrameController.showRegisterFrameWindow();

            loginFrame.setSize(420,350);
            userRegistePanel.setVisible(true);

        }
    }

    private class LoginBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            username = usernameTf.getText();
            password = String.valueOf(txtPwd.getPassword());
//            if (!(username.equals("admin")) || !(password.equals("admin"))) {
//                JOptionPane.showMessageDialog(null, "用户名或密码错误", "提示", JOptionPane.WARNING_MESSAGE);
//                return;
//            }

            try {
                List<UserInfo> list = LoginFrameModel.searchUser();
                for(UserInfo userInfo: list){
                    System.out.println(userInfo.getName() + "  " + userInfo.getPassword());
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }


            MainFrameController mainFrameController = new MainFrameController();
            mainFrameController.showMainFrameWindow();
            loginFrame.setVisible(false);
        }
    }
}
