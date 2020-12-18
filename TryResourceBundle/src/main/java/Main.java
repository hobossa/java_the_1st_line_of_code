import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(Locale.getDefault());
        Locale enUS = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("Messages", enUS);
        System.out.println(rb.getString("hello"));
    }
}
