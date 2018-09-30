package server.entity;

/**
 * music_type 实体类
 */


public class MusicType {
	private int id;
	private String typeName;

    public MusicType() {
    }

    public MusicType(String typeName) {
        this.typeName = typeName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

}

