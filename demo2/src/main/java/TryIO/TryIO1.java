package TryIO;

import java.io.File;
import java.io.IOException;

public class TryIO1 {
    public static void main(String[] args) throws IOException {

        String current = new File(".").getCanonicalPath();
        System.out.println(current);

        String strSrc = current + File.separator + "src"
                + File.separator + "main" + File.separator + "java";

        File file = new File(strSrc);
        if (file.isDirectory()) {
            File[] results = file.listFiles();
            for (File f :
                    results) {
                System.out.println(f);
            }
        }
        System.out.println(file.getPath());
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("create a new file.");
        }
    }
}
