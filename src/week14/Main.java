package shelpam.week14;

public class Main {
    public static void main(String[] args) {
        Thread longWork = new Thread(() -> {
            for (int i = 0; i != 1 << 31; ++i) {
                int a = i * i;
                if (i % (1 << 28) == 0) {
                    System.out.println("longWork: " + i);
                }
            }
        });

        Thread longWork2 = new Thread(() -> {
            for (int i = 0; i != 1 << 31; ++i) {
                int a = i * i;
                if (i % (1 << 28) == 0) {
                    System.out.println("longWork2: " + i);
                }
            }
        });

        longWork.start();
        longWork2.start();

        try {
            // `Thread.join` only guarantees that join won't return until its
            // work is finished, but still may be paused by other threads. So
            // though called `Thread.join`, the control flow may transfer to
            // other thread.
            longWork.join();
            longWork2.join();
        } catch (InterruptedException e) {
        }
    }
}
