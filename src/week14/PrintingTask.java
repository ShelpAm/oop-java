package shelpam.week14;

public class PrintingTask implements Runnable {
    private String name;
    private String[] document;
    private Object mutex;

    public PrintingTask(String name, String[] document) {
        this.name = name;
        this.document = document;
    }

    public void setMutex(Object mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        synchronized (mutex) {
            for (final var line : document) {
                System.out.println(line);
            }
        }
    }
}
