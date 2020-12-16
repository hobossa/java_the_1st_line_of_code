package TryResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestDemo {
    public static void main(String[] args) {
        Locale enUS = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("TryResourceBundle.Messages", enUS);
        System.out.println(rb.getString("hello"));
    }
}
