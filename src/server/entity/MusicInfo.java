package server.entity;

import server.model.SingerModel;

import java.sql.Time;

/**
 * music_info 实体类
 */


public class MusicInfo {
	private int id;
	private String musicName;
	private Time musicTime;
	private int albumId;
	private AlbumInfo album;
	private int singerId;
	private SingerInfo singer;
	private int typeId;

    public MusicInfo() {
    }

    public MusicInfo(String musicName, Time musicTime, int albumId, int singerId, int typeId) {
        this.musicName = musicName;
        this.musicTime = musicTime;
        this.albumId = albumId;
        this.singerId = singerId;
        this.typeId = typeId;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicTime(Time musicTime) {
        this.musicTime = musicTime;
    }

    public Time getMusicTime() {
        return musicTime;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setSinger(SingerInfo singer) {
        this.singer = singer;
    }

    public SingerInfo getSinger() {
        return singer;
    }

    public void setAlbum(AlbumInfo album) {
        this.album = album;
    }

    public AlbumInfo getAlbum() {
        return album;
    }
}

