package TrySystem;

public class TrySystem1 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end - start));
    }

}
