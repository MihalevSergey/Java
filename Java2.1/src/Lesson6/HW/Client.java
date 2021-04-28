package Lesson6.HW;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;

        try {

            socket = new Socket("localHost", 8189);

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner consol = new Scanner(System.in);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String str = in.nextLine();
                        if (str.equals("/ens")){
                            out.println("/end");
                            break;
                        }
                        System.out.println("Server: " + str);

                    }
                }
            });
            t1.start();

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println("Введите сообщение:");
                        String str = consol.nextLine();
                        System.out.println("Сообщение отправлено!");
                        out.println(str);
                    }
                }
            });
            t2.setDaemon(true);
            t2.start();

            try {
                t1.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        }

    }

}
