public class Main {
    public static void main(String args[]) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println("Hello world!");
        // anonymous object
        System.out.println(new Book("Java programming", 9.90).getInfo());
    }
}
