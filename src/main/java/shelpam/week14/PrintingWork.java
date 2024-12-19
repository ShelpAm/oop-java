package shelpam.week14;

import java.util.List;

public class PrintingWork {
    private List<PrintingTask> tasks;
    private Object mutex;

    public PrintingWork(List<PrintingTask> tasks) {
        this.tasks = tasks;
        this.mutex = new Object();

        for (var task : tasks) {
            task.setMutex(mutex);
        }
    }

    public void start() {
        Thread[] threads = new Thread[tasks.size()];
        for (int i = 0; i != threads.length; ++i) {
            threads[i] = new Thread(tasks.get(i));
            threads[i].start();
        }

        for (int i = 0; i != threads.length; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("All tasks have finished.");
    }
}
