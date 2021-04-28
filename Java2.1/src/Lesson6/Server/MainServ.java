package Lesson6.Server;

import com.sun.security.ntlm.Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class MainServ {
    private Vector<ClientHandler> clients;

    public MainServ() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                subscribe(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscibe(ClientHandler client) {
        clients.remove(client);
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }
}


