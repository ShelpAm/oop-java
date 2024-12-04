package shelpam.week14;

public class FiniteStateMachine {
    private shelpam.week14.State[] r;
    private int currentState;
    private final Object mutex = new Object();
    private Thread[] threads;

    public FiniteStateMachine(shelpam.week14.State[] r, int initialState) {
        this.r = r;
        this.currentState = initialState;
        this.threads = new Thread[r.length];

        for (var e : r) {
            e.setMutex(mutex);
            e.setFSM(this);
        }
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setState(int state) {
        currentState = state;
    }

    public void run() {
        int i = 0;
        for (var e : r) {
            threads[i] = new Thread(e);
            threads[i].start();
            ++i;
        }

        for (var t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
            }
        }
    }
}
