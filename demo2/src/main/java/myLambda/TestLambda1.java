package myLambda;
@FunctionalInterface

interface IMessage1 {
    void print();
}

public class TestLambda1 {

    public static void main(String[] args) {
        // using lambda
        fun(() -> System.out.println("myLambda test 1."));
        fun(() -> {
            System.out.println("myLambda test 1 - 1.");
            System.out.println("myLambda test 1 - 2.");
        });
        // using inner class
        fun(new IMessage1() {
            @Override
            public void print() {
                System.out.println("inner class test 1.");
            }
        });
    }

    public static void fun(IMessage1 msg) {
        msg.print();
    }
}
