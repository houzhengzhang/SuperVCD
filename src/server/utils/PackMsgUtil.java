package server.utils;

import org.json.JSONObject;
import server.utils.BytesUtils;

import java.util.Map;


/**
 * @Auther: Administrator
 * @Date: 2018/10/1 20:39
 * @Description:
 */
public class PackMsgUtil {
    /**
     * 将消息长度加在首部
     * @param msgStr
     * @return
     */
    public static byte[] packMsg(String msgStr){
        byte[] msgByte = msgStr.getBytes();
        // 计算消息长度
        int length = msgByte.length;
        // 将消息长度加在首部
        // 消息格式： 长度 + 消息
        msgByte = BytesUtils.addBytes(BytesUtils.int2ByteArrays(length), msgByte);
        return msgByte;
    }
}