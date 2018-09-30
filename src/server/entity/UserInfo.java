package server.entity;

import org.json.JSONObject;

public class UserInfo {
    private int userId;
    private String userName;
    private String userPassword;

    public UserInfo() {
    }

    public UserInfo(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String toString() {
        JSONObject json = new JSONObject(this);
        return json.toString();
    }
}
