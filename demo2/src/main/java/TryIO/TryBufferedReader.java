package TryIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TryBufferedReader {
    public static void main(String[] args) {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please some characters (including some chinese): ");
        try {
            String str = buf.readLine();
            System.out.println("What you input is: " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
