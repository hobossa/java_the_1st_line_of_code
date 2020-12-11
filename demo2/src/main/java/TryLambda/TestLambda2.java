package TryLambda;

@FunctionalInterface
interface IMessage2 {
    int add(int x, int y);
}

public class TestLambda2 {

    public static void main(String[] args) {
        fun((x, y)-> x + y);
    }

    public static void fun(IMessage2 msg) {
        System.out.println(msg.add(10, 20));
    }
}
