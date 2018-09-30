package server.service;

import org.json.JSONObject;
import server.entity.UserInfo;
import server.model.UserModel;
import server.utils.BytesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * @Auther: Administrator
 * @Date: 2018/9/30 15:21
 * @Description:
 */
public class Client implements Runnable {
    private Socket clientSocket = null;
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean bConnected = false;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            bConnected = true;
            new Thread(this).start();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("用户断开连接！");
        }
    }

    public void stopClient() {
        bConnected = false;
        try {
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("关闭流失败！");
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String readMessage(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[4];
        // 读取数据包长度
        inputStream.read(bytes);
        int length = BytesUtils.byteArray2Int(bytes);
        // 读到结束标志，返回""
        if (length == -1)
            return "";
        bytes = new byte[length];
        // 读取数据
        inputStream.read(bytes);
        return new String(bytes);
    }

    @Override
    public void run() {
        while (bConnected) {
            try {
                String msg = readMessage(inputStream);
                if (msg.equals("")) {
                    // 客户端断开连接
                    bConnected = false;
                }
                if (msg.startsWith("login")) {
                    login(msg);
                } else if (msg.startsWith("registe")) {
                    registe(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void login(String msg) {
        // 将socket接受到的数据还原为JSONObject
        int idx = msg.indexOf("{");
        msg = msg.substring(idx);
        JSONObject json = new JSONObject(msg);
        String userNameStr = json.getString("userName");
        String userPasswordStr = json.getString("userPassword");
        String returnMessage ;
        try {
            UserInfo user = UserModel.queryByName(userNameStr);
            if (user == null) {
                // 该用户不存在
                returnMessage = "login#failed";
            } else if(!userPasswordStr.equals(user.getUserPassword())){
                // 密码错误
                returnMessage = "login#failed";
            }  else {
                // 登录成功
                returnMessage = "login#success";
            }
            outputStream.write(returnMessage.getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registe(String msg) {
        // 注册
        // 将socket接受到的数据还原为JSONObject
        int idx = msg.indexOf("{");
        msg = msg.substring(idx);
        JSONObject json = new JSONObject(msg);
        String userNameStr = json.getString("userName");
        String userPasswordStr = json.getString("userPassword");
        String returnMessage ;
        int num = UserModel.insert(userNameStr, userPasswordStr);
        if(num==1){
            // 注册成功
            returnMessage= "registe#success";
        }else {
            returnMessage= "registe#failed";
        }
        try {
            outputStream.write(returnMessage.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
