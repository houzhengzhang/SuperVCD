package server;

import server.service.SocketService;

public class Runner {
    public static void main(String[] args) {
        SocketService socketServer = new SocketService();
        System.out.println("服务端已启动！");
        socketServer.start();
    }
}
