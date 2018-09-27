package service;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.json.JSONObject;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.WildcardType;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
//                Thread thread = new Thread(new HandlerThread(socket));
//                thread.start();
                new HandlerThread(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                while (true) {
                    // 首先读取两个字节表示的长度
                    int length = inputStream.read();
                    //如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
                    if(length==-1){
                        break;
                    }
                    // 然后构造一个指定长的byte数组
                    bytes = new byte[length];
                    // 然后读取指定长度的消息即可
                    inputStream.read(bytes);
                    System.out.println("get message from client: " + new String(bytes, "UTF-8"));

                    // 将socket接受到的数据还原为JSONObject
                    JSONObject json = new JSONObject(new String(bytes));
                    System.out.println(json);
                }
//
//                socket.shutdownInput();
            } catch (SocketException e) {
                //e.printStackTrace();
                System.out.println("client closed!");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
