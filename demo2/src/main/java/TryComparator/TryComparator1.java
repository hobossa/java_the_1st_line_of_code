package TryComparator;

import java.util.Arrays;
import java.util.Comparator;

class Book {
    private String title;
    private double price;

    public double getPrice() {
        return price;
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "title: " + title + ", price: " + price + "\n";
    }
}

class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        if (b1.getPrice() > b2.getPrice()) {
            return 1;
        } else if (b1.getPrice() < b2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class TryComparator1 {
    public static void main(String[] args) {
        Book books[] = new Book[]{
                new Book("Java Programming", 79.8),
                new Book("Java in Action", 69.8),
                new Book("Java Spring", 99.8),
                new Book("Android Development", 89.8)
        };
        Arrays.sort(books, new BookComparator());
        System.out.println(Arrays.toString(books));

        // using lambda
        Arrays.sort(books, (b1, b2) -> {
            if (b1.getPrice() > b2.getPrice()) {
                return -1;
            } else if (b1.getPrice() < b2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
