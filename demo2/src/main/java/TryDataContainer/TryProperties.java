package TryDataContainer;

import java.io.*;
import java.util.Properties;

public class TryProperties {
    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
        pro.setProperty("name", "Jack");
        pro.setProperty("sex", "male");
        System.out.println(pro);
        System.out.println(pro.get("name"));
        pro.store(new FileOutputStream(new File("./test.properties")), "test comment");
        Properties pro2 = new Properties();
        pro2.load(new FileInputStream(new File("./test.properties")));
        System.out.println(pro2);
    }
}
