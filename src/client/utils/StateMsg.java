package client.utils;


import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.json.JSONObject;

/**
 * @Auther: Administrator
 * @Date: 2018/9/30 21:06
 * @Description:
 */
public enum StateMsg {
    LOGIN_SUCCESS_HINT(1000, "登录成功！"),
    REGISTERED_SUCCESS_HINT(1001, "注册成功！"),
    PASSWORD_ERROR_HINT(1002, "密码错误！请重新输入"),
    UNREGISTERED_HINT(1003, "该用户未注册，请先注册！"),
    REGISTERED_ERROR_HINT(1004, "该用户已注册，请登录！");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static StateMsg getStateByCode(int code){
        for(StateMsg s : StateMsg.values()){
            if(s.getCode()==code){
                return s;
            }
        }
        return null;
    }

    public String toString(){
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);

        return json.toString();
    }

    private StateMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static void main(String[] args) {
        System.out.println(StateMsg.LOGIN_SUCCESS_HINT.toString());
    }
}
