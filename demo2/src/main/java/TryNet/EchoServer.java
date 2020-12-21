package TryNet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class EchoServer {
    public static void main(String[] args) throws IOException {
        // serveOneClient();
        serveManyClient();
    }

    public static void serveManyClient() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        boolean flag = true;
        while (flag) {
            Socket client = server.accept();
            new Thread(new EchoThread(client)).start();
        }
        server.close();
    }

    public static void serveOneClient() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();
        Scanner scan = new Scanner(client.getInputStream());
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            if (scan.hasNext()) {
                String str = scan.next().trim();
                if (str.equalsIgnoreCase("exit")) {
                    out.println("disconnect");
                    flag = false;
                } else {
                    out.println("ECHO: " + str);
                }
            }
        }
        scan.close();
        out.close();
        client.close();
        server.close();
    }
}
