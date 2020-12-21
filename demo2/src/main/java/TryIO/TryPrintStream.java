package TryIO;

import java.io.*;

class PrintUtil implements AutoCloseable{
    private OutputStream output;

    public PrintUtil(OutputStream output) {
        this.output = output;
    }

    public void print(String x) {
        try {
            this.output.write(x.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String x) {
        this.print(x.concat("\n"));
    }

    public void print(int x) {
        this.print(String.valueOf(x));
    }

    public void println(int x) {
        this.println(String.valueOf(x));
    }

    public void print(double x) {
        this.print(String.valueOf(x));
    }

    public void println(double x) {
        this.println(String.valueOf(x));
    }

    @Override
    public void close() throws Exception {
        this.output.close();
    }
}


public class TryPrintStream {

    public static void main(String[] args) {
        tryPrintUtil();
        tryPrintStream();
    }

    public static void tryPrintStream() {
        try {
            PrintStream pu = new PrintStream(new FileOutputStream("./printStream.txt", true));
            pu.print("def edu:");
            pu.println("www.def.com");
            pu.println(2+2);
            pu.println(2.2 + 2.2);
            pu.printf("%s %s\n%d\n%1.1f\n", "ghi edu", "www.ghi.com", 6, 6.6);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void tryPrintUtil() {
        try (PrintUtil pu = new PrintUtil( new FileOutputStream("./printStream.txt"))) {
            pu.print("abc edu:");
            pu.println("www.abc.com");
            pu.println(1+1);
            pu.println(1.1 + 1.1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
