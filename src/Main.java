import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Выбор команды:\n 1 - для старта сервера \n 2 - для старта клиента \n 3 - для старта клиента с указанием ip сервера");
        int answer = scanner.nextInt();
        scanner.nextLine();
        if(answer==1) {
            startServer();
        } else
        if(answer==2) {
            startClient("127.0.0.1");
        } else
        if(answer==3) {
            System.out.println("Введите ip сервера:");
            String answer2 = scanner.nextLine();
            startClient(answer2);
        }
    }

    public static void startServer(){
        Server server = new Server();
        System.out.println("Введите ваше сообщение или /end для завершения:");
        while (true) {
            String msg = scanner.nextLine();
            server.sendMsg(msg);
        }
    }

    public static void startClient(String host) {
        Client client = new Client(host);
        System.out.println("Введите ваше сообщение или /end для завершения:");
        while (true) {
            String msg = scanner.nextLine();
            client.sendMsg(msg);
        }
    }

}
