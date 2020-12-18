package TryLambda;


@FunctionalInterface
interface IMessage3 {
    int add(int... args);

    static int sum(int... args) {
        int sum = 0;
        for (int n : args) {
            sum += n;
        }
        return sum;
    }
}

public class TestLambda3 {

    public static void main(String[] args) {
        // using lambda
        fun((int... param) -> IMessage3.sum(param));
    }

    public static void fun(IMessage3 msg) {
        System.out.println(msg.add(10, 20, 30));
    }
}
