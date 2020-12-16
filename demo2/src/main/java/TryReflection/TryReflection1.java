package TryReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

class Book {
    private String title;
    public Book() {
        System.out.println("**** Book constructor without parameters ****");
        title = "This is a book.";
    }

    public Book(String title) {
        System.out.println("**** Book constructor with a title parameter ****");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

public class TryReflection1 {
    public static void main(String[] args) throws Exception {

        Date date = new Date();
        System.out.println(date.getClass()); //class java.util.Date
        System.out.println(date.getClass().getName()); // java.util.Date


        Class<?> cls2 = java.util.Date.class;
        System.out.println(cls2); // class java.util.Date
        System.out.println(cls2.getName()); // java.util.Date


        Class<?> cls3 = null;
        cls3 = Class.forName("java.util.Date");
        System.out.println(cls3); // class java.util.Date
        System.out.println(cls3.getName()); // java.util.Date


        Class<?> cls4 = Class.forName("TryReflection.Book");
        //Object obj = cls4.newInstance();
        Object obj4 = cls4.getDeclaredConstructor().newInstance();
        Book book4 = (Book)obj4;
        System.out.println(book4);

        String fieldName = "title";
        Method setMet = cls4.getMethod("set" + initcap(fieldName), String.class);
        Method getMet = cls4.getMethod("get" + initcap(fieldName));
        setMet.invoke(book4, "somebody has changed my title.");
        System.out.println(getMet.invoke(book4));

        Constructor<?> con4 = cls4.getConstructor(String.class);
        Book book4ex = (Book)con4.newInstance("My book");
        System.out.println(book4ex);

        Field titleField = cls4.getDeclaredField(fieldName);
        titleField.setAccessible(true); // make a private field accessible.
        titleField.set(book4ex, "somebody has changed my book's name");
        System.out.println(titleField.get(book4ex));
    }

    public static String initcap(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}
