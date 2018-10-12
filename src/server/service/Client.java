package server.service;

import client.utils.StatusMsg;
import org.json.JSONArray;
import org.json.JSONObject;
import server.entity.AlbumInfo;
import server.entity.MusicInfo;
import server.entity.MusicType;
import server.entity.SingerInfo;
import server.entity.UserInfo;
import server.model.AlbumModel;
import server.model.MusicModel;
import server.model.MusicTypeModel;
import server.model.OrderModel;
import server.model.SingerModel;
import server.model.UserModel;
import server.utils.BytesUtils;
import server.utils.PackMsgUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;


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

    private String readMessage(InputStream inputStream) throws SocketException, IOException {
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
                // System.out.println("收到的消息： " + msg);
                if (msg.equals("")) {
                    // 客户端断开连接
                    bConnected = false;
                }
                if (msg.startsWith("login")) {
                    login(msg);
                } else if (msg.startsWith("registe")) {
                    registe(msg);
                } else if (msg.startsWith("selectMusic")) {
                    selectMusic(msg);
                } else if (msg.startsWith("selectAlbum")) {
                    selectAlbum(msg);
                } else if (msg.startsWith("selectType")) {
                    selectType();
                }else if (msg.startsWith("selectSinger")) {
                    selectSinger(msg);
                }else if (msg.startsWith("submitOrder")) {
                    submitOrder(msg);
                }
            } catch (SocketException e) {
                // 关闭连接
                stopClient();
                System.out.println("一个客户端中断连接");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void login(String msg) {
        // 将socket接受到的数据还原为JSONObject
        int idx = msg.indexOf("{");
        msg = msg.substring(idx);
        // System.out.println("login方法得到的消息：" + msg);
        JSONObject jsonReceive = new JSONObject(msg);
        String userNameStr = jsonReceive.getString("userName");
        String userPasswordStr = jsonReceive.getString("userPassword");
        StatusMsg state;
        JSONObject jsonData = null;
        byte[] msgByte;

        try {
            UserInfo user = UserModel.queryByName(userNameStr);
            if (user == null) {
                // 该用户不存在
                state = StatusMsg.UNREGISTERED_HINT;
                msgByte = PackMsgUtil.packMsg(state.toString());
            } else if (!userPasswordStr.equals(user.getUserPassword())) {
                // 密码错误
                state = StatusMsg.PASSWORD_ERROR_HINT;
                msgByte = PackMsgUtil.packMsg(state.toString());
            } else {
                // 登录成功
                state = StatusMsg.LOGIN_SUCCESS_HINT;

                jsonData = new JSONObject(user);

            }
            JSONObject jsonStatus = new JSONObject(state);
            JSONObject objData = new JSONObject();
            objData.put("status", jsonStatus);
            if (jsonData != null) {
                objData.put("result", jsonData);
            }

            System.out.println("login返回的消息： " + objData.toString());
            msgByte = PackMsgUtil.packMsg(objData.toString());
            outputStream.write(msgByte);
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
        StatusMsg state;
        int num = UserModel.insert(userNameStr, userPasswordStr);
        if (num == 1) {
            // 注册成功
            state = StatusMsg.REGISTERED_SUCCESS_HINT;
        } else {
            state = StatusMsg.REGISTERED_ERROR_HINT;
        }
        try {
            byte[] msgByte = PackMsgUtil.packMsg(state.toString());
            outputStream.write(msgByte);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectMusic(String msg) {
        int idx = msg.indexOf("{");
        msg = msg.substring(idx);
        JSONObject json = new JSONObject(msg);
        int albumId = json.getInt("albumId");

        try {
            // TODO 缩小抛出异常范围
            List<MusicInfo> musicInfoList = MusicModel.queryByAlbumId(albumId);
            JSONArray jsonArray = new JSONArray(musicInfoList);
            byte[] musicJsonByte = PackMsgUtil.packMsg(jsonArray.toString());

            outputStream.write(musicJsonByte);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectAlbum(String msg) {
        int idx = msg.indexOf("{");
        msg = msg.substring(idx);
        JSONObject json = new JSONObject(msg);
        String albumType = json.getString("albumType");

        try {
            // TODO 缩小抛出异常范围
            List<AlbumInfo> albumInfoList = AlbumModel.queryByType(albumType);
            JSONArray jsonArray = new JSONArray(albumInfoList);
            System.out.println("服务端结果：" + jsonArray.length());
            byte[] albumJsonByte = PackMsgUtil.packMsg(jsonArray.toString());

            outputStream.write(albumJsonByte);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectSinger(String msg) {
        int idx = msg.indexOf("{");
        msg = msg.substring(idx);
        JSONObject json = new JSONObject(msg);
        int albumId = json.getInt("albumId");

        try {
            // TODO 缩小抛出异常范围
            int singerId = AlbumModel.getSingerId(albumId);
            // 查询歌手信息
            SingerInfo singerInfo = SingerModel.queryById(singerId);
            JSONObject jsonObject = new JSONObject(singerInfo);
            byte[] albumJsonByte = PackMsgUtil.packMsg(jsonObject.toString());

            outputStream.write(albumJsonByte);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectType() {

        try {
            // 查询歌曲类型
            List<MusicType> musicTypeList = MusicTypeModel.queryAllType();
            JSONArray jsonArray = new JSONArray(musicTypeList);
            byte[] albumJsonByte = PackMsgUtil.packMsg(jsonArray.toString());

            outputStream.write(albumJsonByte);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitOrder(String msg) {
        int idx = msg.indexOf("{");
        msg = msg.substring(idx);
        JSONObject json = new JSONObject(msg);

        int userId = json.getInt("userId");
        String[] albumStrArr = json.getString("albumIdArr").split(",");

        int[] albumIdArr = new int[albumStrArr.length];
        for (int i = 0; i < albumStrArr.length ; i++) {
            albumIdArr[i] = Integer.parseInt(albumStrArr[i].trim());
        }
        // 返回状态枚举
        StatusMsg state;
        try {
            // TODO 缩小抛出异常范围
            // 插入订单信息
            int numColumn = OrderModel.insert(userId, albumIdArr);
            if(numColumn>0){
                state = StatusMsg.SUBMITORDER_SUCCESS_HINT;
            }else {
                state = StatusMsg.SUBMITORDER_ERROR_HINT;
            }
            byte[] returnMsg = PackMsgUtil.packMsg(state.toString());

            outputStream.write(returnMsg);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SocketService socketServer = new SocketService();
        System.out.println("服务端已启动！");
        socketServer.start();
    }
}
