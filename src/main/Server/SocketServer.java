package main.Server;

import main.dao.UserInfo;
import main.ui.controller.MainFrameController;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class SocketServer {
    boolean started = false;
    private static final int PORT = 12138;
    ServerSocket serverSocket = null;

    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        System.out.println("服务端已启动！");
        socketServer.start();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                // 接受到请求，新开一个线程处理
                new HandlerThread(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理客户端发来的请求
     */
    private class HandlerThread implements Runnable {
        private Socket socket;
        private InputStream inputStream = null;
        private OutputStream outputStream = null;
        private boolean bConnected = false;

        public HandlerThread(Socket socket) {
            this.socket = socket;
            try {
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                bConnected = true;
                new Thread(this).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {

            System.out.println("a client connected!");
            try {
                // 处理客户端发送来的数据
                byte[] bytes;
                while (bConnected) {
                    // 首先读取两个字节表示的长度
                    int length = inputStream.read();
                    //如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
                    if (length == -1) {
                        break;
                    }
                    // 然后构造一个指定长的byte数组
                    bytes = new byte[length];
                    // 然后读取指定长度的消息即可
                    inputStream.read(bytes);


                    // 将socket接受到的数据还原为JSONObject
                    JSONObject json = new JSONObject(new String(bytes));
                    String userNameStr = json.getString("userName");
                    String userPasswordStr = json.getString("userPassword");
                    int op = Integer.parseInt(json.getString("op"));

                    switch (op){
                        case 0:
                            // 登录
                            Map<String, String> returnMessage = new HashMap<>();
                            // 查询数据库 验证登录信息
                            try {
                                UserInfo user = LoginFrameModel.queryByName(userNameStr);
                                if (user == null) {
                                    // 该用户未注册
                                    returnMessage.put("state", "1");
                                } else if (!userPasswordStr.equals(user.getPassword())) {
                                    // 密码错误
                                    returnMessage.put("state", "2");
                                }else {
                                    // 登录成功
                                    returnMessage.put("state", "0");
                                }

                                JSONObject jsonObject = new JSONObject(returnMessage);

                                // 返回给客户端数据
                                String str = jsonObject.toString();
                                outputStream.write(str.length());
                                outputStream.write(str.getBytes());
                                outputStream.flush();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 1:
                            // 注册
                            int num = LoginFrameModel.insertUser(userNameStr, userPasswordStr);

                            break;
                    }
                }
            } catch (SocketException e) {
                System.out.println("client closed!");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
