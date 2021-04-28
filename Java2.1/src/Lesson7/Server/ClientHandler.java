package Lesson7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    Socket socket = null;

    DataInputStream in;
    DataOutputStream out;
    Server server;
    String nick;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();

                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickLoginPass(tokens[1], tokens[2]);
                                if (newNick != null) {
                                    sendMsg("/auth");
                                    nick = newNick;
                                    server.subscribe(ClientHandler.this);
                                    break;
                                } else {
                                    sendMsg("Неверный логи/пароль!");
                                }
                            }
                        }

                        while (true) {
                                String str = in.readUTF();

                            if (str.equals("/end")) {
                                out.writeUTF("/serverClosed");
                                break;
                            }
                            server.broadcasrMsg(str);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
