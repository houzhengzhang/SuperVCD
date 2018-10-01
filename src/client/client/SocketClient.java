package client.client;

import client.utils.PackMsgUtil;
import client.utils.StateMsg;
import org.json.JSONObject;
import server.utils.BytesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/10/1 11:36
 * @Description:
 */
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

    /**
     * 发送消息
     *
     * @param msgByte
     * @throws IOException
     */
    private void sendMsg(byte[] msgByte) throws IOException {
        outputStream.write(msgByte);
        outputStream.flush();
    }

    private StateMsg receiveMsg() {
        // 处理服务端返回的数据
        byte[] bytes = new byte[4];
        try {
            inputStream.read(bytes);
            int length = BytesUtils.byteArray2Int(bytes);
            if (length == -1)
                return StateMsg.SERVER_DISCONNECT_ERROR;
            bytes = new byte[length];
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回枚举
        JSONObject json = new JSONObject(new String(bytes));
        int code = json.getInt("code");
        // TODO 重写 valueof 方法
        return StateMsg.getStateByCode(code);
    }

    /**
     * 关闭连接
     */
    public void disconnect() {
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static SocketClient getSocketClient() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public StateMsg login(String userName, String userPassword) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("userPassword", userPassword);

        byte[] msgByte = PackMsgUtil.packMsg("login", map);
        try {
            sendMsg(msgByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 服务器返回的消息
        return receiveMsg();
    }

    public StateMsg registe(String userName, String userPassword){
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("userPassword", userPassword);

        byte[] msgByte = PackMsgUtil.packMsg("registe", map);
        try {
            sendMsg(msgByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 服务器返回的消息
        return receiveMsg();
    }
}
