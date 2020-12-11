package TryMultiThread;

import org.junit.Test;

public class MyRunnable1Test {
    @Test
    public void test() {
        MyRunnable1 mta = new MyRunnable1("Thread A");
        MyRunnable1 mtb = new MyRunnable1("Thread B");
        MyRunnable1 mtc = new MyRunnable1("Thread C");
        Thread ta = new Thread(mta);
        Thread tb = new Thread(mtb);
        Thread tc = new Thread(mtc);
        // using lambda
        Thread td = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                System.out.println("Thread D-->" + i);
            }
        });
        ta.start();
        tb.start();
        tc.start();
        td.start();
        // new Thread(mta).start();
        try {
            ta.join();
            tb.join();
            tc.join();
            td.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}