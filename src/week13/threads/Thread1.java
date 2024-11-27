package shelpam.week13.threads;

public class Thread1 extends Thread {
    private int x;
    private int max;

    public Thread1(int x, int max) {
        this.x = x;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i * x <= max; ++i) {
            System.out.println("Thread1: " + i * x);
        }
        System.out.println("Thread1 finished.");
    }

    // Implicit `void start();` because of inheritance.
}
