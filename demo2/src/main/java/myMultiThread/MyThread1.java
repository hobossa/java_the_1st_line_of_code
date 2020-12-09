package myMultiThread;

public class MyThread1 extends Thread {
    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(this.name + "-->" + i);
        }
    }
}
