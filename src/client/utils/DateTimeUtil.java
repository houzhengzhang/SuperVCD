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

    public static String addTimeStr(String timeStr1, String timeStr2) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date1 = null, date2 = null;
        java.util.Date absBeg = null;
        try {
            date1 = format.parse(timeStr1);
            date2 = format.parse(timeStr2);
            absBeg = format.parse("00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long addTime = date1.getTime() + date2.getTime() + 2 * absBeg.getTime();
        String str = new SimpleDateFormat("HH:mm:ss").format(addTime);
        return str;
    }

    public static void main(String[] args) {
        String timeStr = "00:55:00";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        java.util.Date d = null;
        java.util.Date absBeg = null;
        try {
            d = format.parse(timeStr);
            absBeg = format.parse("00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("d: " + d.getTime());
        System.out.println("beg: " + absBeg.getTime());
        long add = (d.getTime() + absBeg.getTime()) * 2;

        String str = new SimpleDateFormat("HH:mm:ss").format(add);
        System.out.println(str);
    }
}
