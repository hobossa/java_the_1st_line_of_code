package TryNet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("waiting for clients to connect...");
        Socket client = server.accept();
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("Hello world!");
        out.close();;
        client.close();
        server.close();
    }

}
