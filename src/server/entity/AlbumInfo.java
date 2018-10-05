package server.entity;

import server.utils.ImgIOJsonOutputUtils;

import java.io.IOException;
import java.sql.Date;

/**
 * album_info 实体类
 */ 


public class AlbumInfo {
	private int id;
	private String albumName;
	private int typeId;
	private int singerId;
	private Date publicDate;
	private String publicCompany;
	private double price;
	private String imgUrl;

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

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getSingerId() {
        return singerId;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 返回编码后的图片
     * @return
     */
    public String getImgUrl() {
        return imgUrl;
    }
//        try {
//            return ImgIOJsonOutputUtils.encodeImage(imgUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}

