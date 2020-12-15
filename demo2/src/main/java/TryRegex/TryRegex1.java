package TryRegex;

import javax.swing.text.Style;

public class TryRegex1 {
    public static void main(String[] args) {
        String str1 = "123abc";
        System.out.println(str1.matches("\\d+"));

        String str2 = "Hello*()(*)*&*^&%&*%World!@#$12341324";
        String regex2 = "[^a-zA-Z]";
        System.out.println(str2.replaceAll(regex2, ""));

        String str3 = "hello1world2again";
        String regex3 = "\\d+";
        String result3[] = str3.split(regex3);
        for (String s :
                result3) {
            System.out.println(s);
        }

        String str4 = "12.12";
        String regex4 = "\\d+(\\.\\d+)?";
        if (str4.matches(regex4)) {
            System.out.println(Double.parseDouble(str4));
        }
    }
}
