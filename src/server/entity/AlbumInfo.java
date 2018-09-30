package server.entity;

import java.util.Date;

/**
 * album_info 实体类
 */


public class AlbumInfo {
    private int id;
    private String albumName;
    private Date publicDate;
    private String publicCompany;

    public AlbumInfo() {
    }

    public AlbumInfo(String albumName, Date publicDate, String publicCompany) {
        this.albumName = albumName;
        this.publicDate = publicDate;
        this.publicCompany = publicCompany;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicCompany(String publicCompany) {
        this.publicCompany = publicCompany;
    }

    public String getPublicCompany() {
        return publicCompany;
    }

}

