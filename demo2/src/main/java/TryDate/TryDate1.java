package TryDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TryDate1 {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();   // current time. It is same to new Date(System.currentTRimeMillis());
        System.out.println(d1);

        long cur = System.currentTimeMillis();
        System.out.println(cur);
        Date d2 = new Date(cur);
        System.out.println(d2);
        System.out.println(d2.getTime());   // cur

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = sdf.format(d2);
        System.out.println(str);

        Date d3 = sdf.parse(str);
        System.out.println(d3);
        System.out.println(d3.equals(d2));
    }
}
