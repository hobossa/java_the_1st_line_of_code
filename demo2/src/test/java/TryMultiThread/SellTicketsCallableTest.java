package TryMultiThread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SellTicketsCallableTest {
    @Test
    public void test() {
        SellTicketsCallable sc = new SellTicketsCallable(10);
        FutureTask<String> task1 = new FutureTask<>(sc);
        FutureTask<String> task2 = new FutureTask<>(sc);
        FutureTask<String> task3 = new FutureTask<>(sc);

        // multi thread share a runnable object.
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
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
        try {
            System.out.println(task1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}