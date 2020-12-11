package TryMultiThread;

public class MyRunnable1 implements Runnable {
    private String name;

    public MyRunnable1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(this.name + "-->" + i);
        }
    }
}
