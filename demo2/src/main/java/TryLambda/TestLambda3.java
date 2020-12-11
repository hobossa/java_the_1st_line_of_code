package TryLambda;

// 关于 @FunctionalInterface 注释的使用
// 在 Lambda 表达式中已经明确要求是在接口上进行的一种操作，并且接口中只允许定义一个抽象方法。
// 但是在一个项目开发中往往会定义大量的接口，而为了区分出 Lambda 表达式使用的接口，可以在接口
// 上使用 @FunctionalInterface 注解声明，这样就表示此为函数式接口，里面只允许定义一个抽象
// 方法。
// 从理论上来讲，如果一个接口只有一个抽象方法，写不写这个注解是没有区别的，但还是建议写上。
// 同时需要注意的是，在函数式接口中依然可以定义普通方法与静态方法。

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
        // 在 Lambda 表达中直接调用接口定义的静态方法。
        fun((int... param) -> IMessage3.sum(param));
    }

    public static void fun(IMessage3 msg) {
        System.out.println(msg.add(10, 20, 30));
    }
}
