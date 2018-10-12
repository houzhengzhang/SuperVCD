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
     *
     * @param bytes1
     * @param bytes2
     * @return
     */
    public static byte[] connectBytes(byte[] bytes1, byte[] bytes2) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes1.length + bytes2.length);
        baos.write(bytes1, 0, bytes1.length);
        baos.write(bytes2, 0, bytes2.length);

        return baos.toByteArray();
    }

    /**
     * 重载
     *
     * @param bytes1
     * @param bytes2
     * @param bytes3
     * @return
     */
    public static byte[] connectBytes(byte[] bytes1, byte[] bytes2, byte[] bytes3) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes1.length + bytes2.length + bytes3.length);
        baos.write(bytes1, 0, bytes1.length);
        baos.write(bytes2, 0, bytes2.length);
        baos.write(bytes3, 0, bytes3.length);

        return baos.toByteArray();
    }

    /**
     * int 转 byte 数组
     *
     * @param a
     * @return
     */
    public static byte[] int2ByteArrays(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * byte 数组 转 int
     *
     * @param b
     * @return
     */
    public static int byteArray2Int(byte[] b) {
        return b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static void main(String[] args) {
        byte[] bytes = int2ByteArrays(9);
        int n = byteArray2Int(bytes);
        System.out.println(n);
    }
}
