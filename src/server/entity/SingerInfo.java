package server.entity;

/**
 * singer_info 实体类
 */


public class SingerInfo {
    private int id;
    private String singerName;
    private String singerInfo;

    public SingerInfo() {
    }

    public SingerInfo(String singerName, String singerInfo) {
        this.singerName = singerName;
        this.singerInfo = singerInfo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerInfo(String singerInfo) {
        this.singerInfo = singerInfo;
    }

    public String getSingerInfo() {
        return singerInfo;
    }

}

