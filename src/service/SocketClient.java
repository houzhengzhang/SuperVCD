package service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;

public class SocketClient {
    private static SocketClient socketClient = null;

    private String host = "127.0.0.1";
    private int port = 12138;
    private Socket socket;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;

    public SocketClient() {
        try {
            socket = new Socket(host, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void receiveMessage(){

    }

    public void sendMessage(){
        //向服务器端发送数据
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name","张三");
            map.put("number", "123456");
            //将json转化为String类型
            JSONObject json = new JSONObject(map);
            String jsonString = json.toString();

            byte[] jsonByte = jsonString.getBytes();
            // 先将消息的长度发送
            outputStream.write(jsonByte.length);
            //然后将消息再次发送出去
            outputStream.write(jsonByte);
            outputStream.flush();
//            socket.shutdownOutput();
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 实现单例模式
     *
     * @return
     */
    public static SocketClient getSocketClient() {
        try {
            if (socketClient == null) {
                socketClient = new SocketClient();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return socketClient;
    }

    public static void main(String[] args) {
        SocketClient sc = new SocketClient();
        for (int i = 0; i < 5; i++) {
//            Scanner scanner = new Scanner(System.in);
//            String string = scanner.nextLine();
            sc.sendMessage();
        }
    }
//
//    public static void main(String[] args) throws Exception{
//        for (int i = 0; i <1 ; i++) {
//            SocketClient socketClient =new SocketClient();
//            socketClient.client();
//        }
//    }
//    public void client() throws Exception {
//        // 要连接的服务端IP地址和端口
//        String host = "127.0.0.1";
//        int port = 55533;
//        // 与服务器建立连接
//        Socket socket = new Socket(host, port);
//        // 建立连接后获得输出流
//        OutputStream dos = socket.getOutputStream();
//
//            String message = "hello world!\n";
//        for (int i = 0; i <5 ; i++) {
//
//            dos.write(message.getBytes("UTF-8"));
//            dos.flush();
//        }
//        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据,否则无法接受数据
//        //socket.shutdownOutput();
//        for (int i = 0; i <5 ; i++) {
//
//            dos.write(message.getBytes("UTF-8"));
//            dos.flush();
//        }
//
//        InputStream inputStream = socket.getInputStream();
//        StringBuilder stringBuilder = new StringBuilder();
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = inputStream.read(bytes)) != -1) {
//            stringBuilder.append(new String(bytes, 0, len, "UTF-8"));
//        }
//
//        System.out.println("get message from server: " + stringBuilder);
//        dos.close();
//        inputStream.close();
//        socket.close();
//
//    }
}
