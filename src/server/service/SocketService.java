package server.service;

import server.entity.UserInfo;
import org.json.JSONObject;
import server.model.UserModel;
import server.utils.BytesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class SocketService {
    boolean started = false;
    private static final int PORT = 12138;
    ServerSocket serverSocket = null;

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                // 接受到请求，新开一个线程处理
                System.out.println("一个客户端已连接！");
                new Client(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
