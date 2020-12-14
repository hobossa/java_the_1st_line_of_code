package TryDate;

import java.util.Calendar;

public class TraCalendar1 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        StringBuffer buf = new StringBuffer();
        buf.append(cal.get(Calendar.YEAR))
                .append("-")
                .append(cal.get(Calendar.MONTH))
                .append("-")
                .append(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(buf);
    }
}
