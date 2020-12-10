package myMultiThread;

class Message {
    private String title;
    private String content;
    private boolean flag = true; // true means can be set, false means can be got

    public synchronized void set(String title, String content) {
        if (!this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;
        super.notify();
    }

    public synchronized void get() {
        if (this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.title + "-->" + this.content);
        this.flag = true;
        super.notify();
    }
}

class Producer implements Runnable {
    private Message msg = null;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                this.msg.set("Ma", "996 is your best reward.");
            } else {
                this.msg.set("Ma", "Tech for good.");
            }
        }
    }
}

class Consumer implements Runnable {
    private Message msg = null;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.msg.get();
        }
    }
}

public class ProducerAndConsumer {
    public static void main(String[] args) throws Exception {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}
