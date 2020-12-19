package TryIO;

import java.io.*;

class Net implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Net close");
    }

    public void info() throws Exception {
        System.out.println("Net info");
    }
}

public class TryIO2 {
    public static void main(String[] args) {
        // print system properties.
        System.getProperties().list(System.out);


        // AutoCloseable
        try (Net n = new Net()) {
            n.info();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n");

        String str = "hello java.\n";

        File file1 = new File("." + File.separator + "test.txt");
        // OutputStream
        try {
            OutputStream output = new FileOutputStream(file1);
            output.write(str.getBytes());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // or we can use try to close a AutoCloseable object.
        try (OutputStream append = new FileOutputStream(file1, true)) {
            append.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // InputStream
        try (InputStream input = new FileInputStream(file1)) {
            byte[] data = new byte[1024];
            int len = input.read(data);
            System.out.println(new String(data, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Writer
        try (Writer out = new FileWriter(file1, true)) {
            out.append(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reader
        try (Reader reader = new FileReader(file1)) {
            char[] data = new char[1024];
            int len = reader.read(data);
            System.out.println(new String(data, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        }

        copy("./copy.txt", "./test.txt");

        // InputStreamReader can convert an InputStream to a Reader.
        // OutputStreamWriter can convert an OutputStream to a Writer.

        // Memory stream and reader writer
        // ByteArrayInputStream, ByteArrayOutputStream
        // CharArrayReader, CharArrayWriter

    }

    public static boolean copy(String fileDest, String fileSrc) {
        boolean bR = false;
        File inFile = new File(fileSrc);
        File outFile = new File(fileDest);

        try {
            InputStream input = new FileInputStream(inFile);
            OutputStream output = new FileOutputStream(outFile);
            int temp = 0;
            byte[] data = new byte[1024];
            while ((temp = input.read(data))!= -1) {
                output.write(data, 0, temp);
            }
            input.close();
            output.close();
            bR = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bR;
    }

}
