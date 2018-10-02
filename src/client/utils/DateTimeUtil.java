package client.utils;

import java.text.SimpleDateFormat;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 11:02
 * @Description:
 */
public class DateTimeUtil {
    /**
     * 返回java.sql.Time格式的
     *
     * @param strDate
     * @return
     */
    public static String strToTime(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        java.util.Date d = null;
        try {
            d = format.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = new SimpleDateFormat("mm:ss").format(d.getTime());
        return str;
    }

    /**
     * 返回java.sql.Date格式的
     *
     * @param strDate
     * @return
     */
    public static java.sql.Date strToDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }
}
