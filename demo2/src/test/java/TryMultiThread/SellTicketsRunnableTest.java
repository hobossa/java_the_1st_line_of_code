package TryMultiThread;

import org.junit.Test;

public class SellTicketsRunnableTest {
    @Test
    public void test() {
        SellTicketsRunnable st = new SellTicketsRunnable(10);
        // multi thread share a runnable object.
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        Thread t3 = new Thread(st);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}