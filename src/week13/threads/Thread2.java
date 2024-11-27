package shelpam.week13.threads;

public class Thread2 implements Runnable {
    private Thread t;
    private int x;
    private int max;

    public Thread2(int x, int max) {
        t = new Thread(this);
        this.x = x;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i * x <= max; ++i) {
            System.out.println("Thread2: " + i * x);
        }
        System.out.println("Thread2 finished.");
    }

    public void start() {
        t.start();
    }

    public void join() throws InterruptedException {
        t.join();
    }
}
