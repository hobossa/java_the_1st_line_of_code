package TryMultiThread;

import org.junit.Test;

public class MyThread1Test {
    @Test
    public void test() {
        MyThread1 mta = new MyThread1("Thread A");
        MyThread1 mtb = new MyThread1("Thread B");
        MyThread1 mtc = new MyThread1("Thread C");
        mta.start();;
        mtb.start();
        mtc.start();
        try {
            mta.join();
            mtb.join();
            mtc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}