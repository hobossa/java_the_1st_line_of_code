public class FruitFactory {
    public static Fruit getInstance(String fruitName) {
        if ("apple".equalsIgnoreCase(fruitName)){
            return new Apple();
        } else if ("orange".equalsIgnoreCase(fruitName)) {
            return new Orange();
        } else {
            return null;
        }
    }
}
