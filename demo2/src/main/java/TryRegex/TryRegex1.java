package TryRegex;

import javax.swing.text.Style;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryRegex1 {
    public static void main(String[] args) {
        String str1 = "123abc";
        System.out.println(str1.matches("\\d+"));

        String str2 = "Hello*()(*)*&*^&%&*%World!@#$12341324";
        String regex2 = "[^a-zA-Z]";
        System.out.println(str2.replaceAll(regex2, ""));

        String str3 = "hello1world2again";
        String regex3 = "\\d+";
        String[] result3 = str3.split(regex3);
        for (String s :
                result3) {
            System.out.println(s);
        }

        String str4 = "12.12";
        String regex4 = "\\d+(\\.\\d+)?";
        if (str4.matches(regex4)) {
            System.out.println(Double.parseDouble(str4));
        }

        String str5 = "192.168.1.1";
        // String regex5 = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        String regex5 = "(\\d{1,3}\\.){3}\\d{1,3}";
        System.out.println(str5.matches(regex5));

        String str6 = "2020-12-12";
        String regex6 = "\\d{4}-\\d{2}-\\d{2}";
        if (str6.matches(regex6)) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str6);
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // phone numers
        // format 1 1234567  "\\d{7,8}"
        // format 2 010-12345678 "\\d{3,4}-\\d{7,8}"
        // format 3 (010)-12345678 "\\(\\d{3,4}\\)-\\d{7,8}"
        // all in one "((\\d{3,4})|(\\(\\d{3,4}\\)))-)?\\d{7,8}"
        String phone1 = "1234567";
        String phone2 = "010-1234567";
        String phone3 = "(010)-1234567";
        String regexPhone = "(((\\d{3,4})|(\\(\\d{3,4}\\)))-)?\\d{7,8}";
        System.out.println(phone1.matches(regexPhone));
        System.out.println(phone2.matches(regexPhone));
        System.out.println(phone3.matches(regexPhone));

        // email
        String strEmail = "test_te@gmail.com";
        String regexEmail = "\\w+@\\w+\\.\\w+";
        System.out.println(strEmail.matches(regexEmail));


        // using Pattern
        String str7 = "hello123world123";
        String regex7 = "\\d+";
        Pattern pattern7 = Pattern.compile(regex7);
        String[] result7 = pattern7.split(str7);
        System.out.println(Arrays.toString(result7));

        // Using Pattern and Matcher
        String str8 = "100";
        String regex8 = "\\d+";
        Pattern pattern8 = Pattern.compile(regex8);
        Matcher mat8 = pattern8.matcher(str8);
        System.out.println(mat8.matches());
    }
}
