package client.client;

import client.utils.PackMsgUtil;
import client.utils.StatusMsg;
import org.json.JSONArray;
import org.json.JSONObject;
import server.utils.BytesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
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

    private Map<String, Object> receiveStatusMsg() {
        // 处理服务端返回的数据
        Map<String, Object> map = new HashMap<>();
        byte[] bytes = new byte[4];
        try {
            inputStream.read(bytes);
            int length = BytesUtils.byteArray2Int(bytes);
            if (length == -1) {
                map.put("status", StatusMsg.SERVER_DISCONNECT_ERROR);
                return map;
            }
            bytes = new byte[length];
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回枚举
        JSONObject jsonReceive = new JSONObject(new String(bytes));
        int code = jsonReceive.getJSONObject("status").getInt("code");

        map.put("status", StatusMsg.getStateByCode(code));
        // 登录成功返回用户信息
        if (code == StatusMsg.LOGIN_SUCCESS_HINT.getCode()) {
            map.put("user", jsonReceive.getJSONObject("result"));
        }

        return map;
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

    /**
     * 登录请求
     *
     * @param userName
     * @param userPassword
     * @return
     */
    public Map<String, Object> login(String userName, String userPassword) {
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
        return receiveStatusMsg();
    }

    /**
     * 注册请求
     *
     * @param userName
     * @param userPassword
     * @return
     */
    public Map<String, Object> registe(String userName, String userPassword) {
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
        return receiveStatusMsg();
    }


    private JSONArray receiveInfoArray() {
        byte[] bytes = new byte[4];
        try {
            inputStream.read(bytes);
            int length = BytesUtils.byteArray2Int(bytes);
            bytes = new byte[length];
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray(new String(bytes));
        return jsonArray;
    }

    private JSONObject receiveJSONObject() {
        byte[] bytes = new byte[4];
        try {
            inputStream.read(bytes);
            int length = BytesUtils.byteArray2Int(bytes);

            bytes = new byte[length];
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(new String(bytes));
        return jsonObject;
    }

    /**
     * 查询歌曲请求
     *
     * @param albumId
     */
    public JSONArray selectMusic(int albumId) {
        Map<String, Object> map = new HashMap<>();
        map.put("albumId", albumId);

        byte[] msgByte = PackMsgUtil.packMsg("selectMusic", map);
        try {
            sendMsg(msgByte);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receiveInfoArray();
    }

    /**
     * 查询专辑请求
     *
     * @param albumName
     * @return
     */
    public JSONArray selectAlbum(String albumName) {
        Map<String, Object> map = new HashMap<>();
        map.put("albumType", albumName);

        byte[] msgByte = PackMsgUtil.packMsg("selectAlbum", map);
        try {
            sendMsg(msgByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receiveInfoArray();
    }

    /**
     * 查询歌手请求
     *
     * @param albumId
     * @return
     */
    public JSONObject selectSinger(int albumId) {
        Map<String, Object> map = new HashMap<>();
        map.put("albumId", albumId);
        byte[] msgByte = PackMsgUtil.packMsg("selectSinger", map);
        try {
            sendMsg(msgByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receiveJSONObject();
    }

    /**
     * 提交订单信息
     *
     * @param userId
     * @param albumIdArr
     */
    public JSONObject submitOrder(int userId, int[] albumIdArr) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        String albumStr = Arrays.toString(albumIdArr);
        map.put("albumIdArr", albumStr.substring(1, albumStr.length() - 1));
        System.out.println("发送的albumIdArr substr: " + albumStr.substring(1, albumStr.length() - 1));
        byte[] msgByte = PackMsgUtil.packMsg("submitOrder", map);
        try {
            sendMsg(msgByte);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receiveJSONObject();

    }
    /**
     * 查询音乐类型
     *
     * @return
     */
    public JSONArray selectType() {
        Map<String, Object> map = new HashMap<>();
        byte[] msgByte = PackMsgUtil.packMsg("selectType", map);
        try {
            sendMsg(msgByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receiveInfoArray();
    }

}
