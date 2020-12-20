package TryIO;

import java.io.*;

public class TryMemoryIO {
    public static void main(String[] args) {
        toUpper();
    }

    public static void toUpper() {
        String str = "hello world";
        InputStream input = new ByteArrayInputStream(str.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        try {
            while ((temp = input.read()) != -1) {
                output.write(Character.toUpperCase(temp));
            }
            System.out.println(output);
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
