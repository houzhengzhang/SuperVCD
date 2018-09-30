package server.utils;

import java.io.ByteArrayOutputStream;

/**
 * @Auther: Administrator
 * @Date: 2018/9/30 15:36
 * @Description:
 */
public class BytesUtils {

    /**
     * 合并 byte 数组
     * @param bytes1
     * @param bytes2
     * @return
     */
    public static byte[] addBytes(byte[] bytes1, byte[] bytes2) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes1.length + bytes2.length);
        baos.write(bytes1, 0, bytes1.length);
        baos.write(bytes2, 0, bytes2.length);

        return baos.toByteArray();
    }

    /**
     * 重载
     * @param bytes1
     * @param bytes2
     * @param bytes3
     * @return
     */
    public static byte[] addBytes(byte[] bytes1, byte[] bytes2, byte[] bytes3) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes1.length + bytes2.length + bytes3.length);
        baos.write(bytes1, 0, bytes1.length);
        baos.write(bytes2, 0, bytes2.length);
        baos.write(bytes3, 0, bytes3.length);

        return baos.toByteArray();
    }

    /**
     * int 转 byte 数组
     * @param i
     * @return
     */
    public static byte[] int2ByteArrays(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }

    /**
     * byte 数组 转 int
     * @param b
     * @return
     */
    public static int byteArray2Int(byte[] b) {
        int intValue = 0;
        for (int i = 0; i < b.length; i++) {
            intValue += (b[i] & 0xFF) << (8 * (3 - i)); //int占4个字节（0，1，2，3）
        }
        return intValue;
    }

    public static void main(String[] args) {
        byte[] bytes = int2ByteArrays(9);
        int n = byteArray2Int(bytes);
        System.out.println(n);
    }
}
