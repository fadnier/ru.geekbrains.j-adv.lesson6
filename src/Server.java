import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final int PORT = 2020;
    private ServerSocket server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    public Server() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server = new ServerSocket(PORT);
                    System.out.println("Запуск сервера");

                    socket = server.accept();
                    System.out.println("Новый клиент подключился");

                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            sendMsg(str);
                            break;
                        }
                        System.out.println("Клиент:" + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        server.close();
                        System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void sendMsg(String str) {
        try {
            out.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
