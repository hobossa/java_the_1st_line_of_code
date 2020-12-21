package TryNet;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HelloClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");
        if (scan.hasNext()) {
            System.out.println(scan.next());
        }
        scan.close();
        client.close();
    }
}
