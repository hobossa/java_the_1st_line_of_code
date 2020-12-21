package TryNet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoThread implements Runnable {
    private Socket client;

    public EchoThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
