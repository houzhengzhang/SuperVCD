package client.utils;

import org.json.JSONObject;
import server.utils.BytesUtils;

import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/10/1 09:25
 * @Description:
 */
public class PackMsgUtil {
    /**
     * 将消息添加前缀及首部
     * @param prefix
     * @param map
     * @return
     */
    public static byte[] packMsg(String prefix, Map<String, Object> map){
        // 将json转化为String类型
        JSONObject json = new JSONObject(map);
        // 拼接消息
        String msgStr = prefix + json.toString();
        // 将拼接后的消息转换为byte数组
        byte[] msgByte = msgStr.getBytes();
        // 计算消息长度
        int length = msgByte.length;
        // 将消息长度加在首部
        // 消息格式： 长度 + 消息
        msgByte = BytesUtils.addBytes(BytesUtils.int2ByteArrays(length), msgByte);
        return msgByte;
    }
}
