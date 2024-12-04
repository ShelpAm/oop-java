package shelpam.week14;

public class NoticeBoard {
    // Assume that the number of messages doesn't exceed 20.
    private String[] notices = new String[20];
    private int size = 0;
    private final Object mutex = new Object();

    public void add(String notice) {
        synchronized (mutex) {
            notices[size++] = notice;
        }
    }

    public void printAll() {
        for (int i = 0; i != size; ++i) {
            System.out.println(notices[i]);
        }
    }
}
