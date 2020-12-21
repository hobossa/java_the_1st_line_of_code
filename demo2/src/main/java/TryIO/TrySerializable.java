package TryIO;

import java.io.*;

class Book implements Serializable {
    // private transient String title; // using transient to indicate this field does not need to be serialized.
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "title: " + title + ". price: " + price;
    }
}

public class TrySerializable {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("./book.ser")));
            oos.writeObject(new Book("Java programming", 9.9));
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("./book.ser")));
            Book book = (Book)ois.readObject();
            System.out.println(book);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
