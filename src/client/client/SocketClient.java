package client.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import client.utils.StateMsg;
import org.json.JSONObject;
import server.utils.BytesUtils;



public class SocketClient {

    private static SocketClient socketClient = null;

    private String host = "127.0.0.1";
    private int port = 12138;
    private Socket socket;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;

    private SocketClient() {
        try {
            socket = new Socket(host, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int receiveMessage() {
        // 处理服务端返回的数据
        try {
            byte[] bytes;
            int length = inputStream.read();
            if (length == -1)
                return -1;

            bytes = new byte[length];
            inputStream.read(bytes);

            // 将字符串还原为 Json 对象
            JSONObject json = new JSONObject(new String(bytes));
            int state = Integer.parseInt(json.getString("state"));

            return state;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void disconnect() {
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(int op, String userNameStr, String userPasswordStr) {
        //向服务器端发送数据
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("op", op + "");
            map.put("userName", userNameStr);
            map.put("userPassword", userPasswordStr);

            //将json转化为String类型
            JSONObject json = new JSONObject(map);
            System.out.println("发送json数据： " + json.toString());
            String jsonString = json.toString();

            byte[] jsonByte = jsonString.getBytes();
            // 先将消息的长度发送
            int length = jsonByte.length;
            byte[] sendByte = BytesUtils.addBytes(BytesUtils.int2ByteArrays(length), jsonByte);
            System.out.println("发送数据长度： " + length);
            // 消息格式： 长度 + 消息
            outputStream.write(sendByte);
            outputStream.flush();
        } catch (IOException e) {
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
        SocketClient sc = SocketClient.getSocketClient();
        for (int i = 0; i < 5; i++) {
            // 向服务端发送数据
            sc.sendMessage(i, "张三", "123456");
            // 接收服务端返回的数据
            sc.receiveMessage();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
