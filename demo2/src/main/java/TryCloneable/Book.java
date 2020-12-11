package TryCloneable;

// Interface does not have any method. It is a kind of mark interface which
// is used to show a certain ability.

public class Book implements Cloneable {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "title: " + title + ". price: " + price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // the modifier of clone in super class is protected.
        // so we have to override clone method and call super.clone()
        // to enable clone ability.
        return super.clone();
    }

    public static void main(String[] args) throws Exception {
        Book bookA = new Book("Java programming", 9.9);
        Book bookB = (Book) bookA.clone();
        System.out.println(bookA == bookB);
        System.out.println(bookA);
        System.out.println(bookB);
    }
}
