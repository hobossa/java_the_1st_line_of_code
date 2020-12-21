package TryNet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",  9999);
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(client.getInputStream());
        PrintStream out = new PrintStream(client.getOutputStream());
        input.useDelimiter("\n");
        scan.useDelimiter("\n");
        boolean flag = true;
        while (flag) {
            System.out.println("Please input command: ");
            if (input.hasNext()) {
                String str = input.next().trim();
                out.println(str);
                if (str.equalsIgnoreCase("exit")) {
                    flag = false;
                }
                if (scan.hasNext()) {
                    System.out.println(scan.next());
                }
            }
        }
        input.close();
        scan.close();
        out.close();
        client.close();
    }
}
