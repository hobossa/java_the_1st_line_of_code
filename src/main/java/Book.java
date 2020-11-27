public class Book {
    private String title;
    private double price = 0.0;

    public Book() {
    }

    public Book(String title) {
        setTitle(title);
    }

    public Book(String title, double price) {
        setTitle(title);
        setPrice(price);
    }

    public String getInfo() {
        return "书名: " + title + ", 价格: " + price;
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
        if (price > 0.0) {
            this.price = price;
        }
    }
}
