package myMultiThread;

import java.util.concurrent.Callable;

public class SellTicketsCallable implements Callable<String> {
    private int ticketCount;

    public SellTicketsCallable(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            if (ticketCount > 0) {
                System.out.println(Thread.currentThread() + " Sold a ticket, " + ticketCount-- +" tickets left.");
            }
        }
        return "All tickets are sold out.";
    }
}
