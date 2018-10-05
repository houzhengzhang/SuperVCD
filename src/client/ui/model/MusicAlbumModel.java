package client.ui.model;

import client.client.SocketClient;
import org.json.JSONArray;

/**
 * @Auther: Administrator
 * @Date: 2018/10/5 10:32
 * @Description:
 */
public class MusicAlbumModel {
    private SocketClient client = SocketClient.getSocketClient();
    public JSONArray selectAlbum(String albumName){
        JSONArray items = client.selectAlbum(albumName);
        System.out.println(items);
        return items;
    }

    public static void main(String[] args) {
        MusicAlbumModel musicAlbumModel = new MusicAlbumModel();
        musicAlbumModel.selectAlbum("流行");
    }
}
