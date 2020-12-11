package TryMethodReference;

@FunctionalInterface
interface IMessage1<P, R> {
    R fun(P p);
}

@FunctionalInterface
interface IMessage2<R> {
    R fun();
}

@FunctionalInterface
interface IMessage3<P> {
    int fun(P p1, P p2);
}

@FunctionalInterface
interface IMessage4<C> {
    C fun(String t, double p);
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name : " + name + " price : " + price;
    }
}

public class TestDemo {

    public static void main(String[] args) {
        // static method reference
        IMessage1<Integer, String> msg1 = String::valueOf;
        String str = msg1.fun(1000);
        System.out.println(str);

        // instance method reference
        String hello = "hello";
        IMessage2<String> msg2 = hello::toUpperCase;
        System.out.println(msg2.fun());

        // normal method reference
        IMessage3<String> msg3 = String::compareTo;
        System.out.println(msg3.fun("A", "B"));

        // constructor reference
        IMessage4<Book> msg4 = Book::new;
        Book book = msg4.fun("java programing", 12.34);
        System.out.println(book);
    }
}
