package main.dao;

public class UserInfo {
    private int id;
    private String name;
    private String password;

    public UserInfo(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
