package TryMultiThread;

public class SellTicketsRunnable implements Runnable {
    private int ticketCount;

    public SellTicketsRunnable(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                if (ticketCount > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "Sold a ticket, " + (--ticketCount) +" tickets left.");
                }
            }
        }
    }
}
