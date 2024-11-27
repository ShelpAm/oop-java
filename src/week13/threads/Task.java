package shelpam.week13.threads;

public class Task implements Runnable {
    private int x;
    private int max;

    public Task(int x, int max) {
        this.x = x;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i * x <= max; ++i) {
            System.out.println("Thread3: " + i * x);
        }
        System.out.println("Thread3 finished.");
    }
}
