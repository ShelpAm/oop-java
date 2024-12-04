package shelpam.week14;

public class State implements Runnable {
    private final int me, next;
    private String work;
    private Object mutex;
    private FiniteStateMachine fsm;

    public State(int me, int next, String work) {
        this.me = me;
        this.next = next;
        this.work = work;
    }

    public void setMutex(Object mutex) {
        this.mutex = mutex;
    }

    public void setFSM(FiniteStateMachine fsm) {
        this.fsm = fsm;
    }

    @Override
    public void run() {
        var s = work.toCharArray();
        for (char c : s) {
            synchronized (this.mutex) {
                while (fsm.getCurrentState() != me) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                fsm.setState(next);
                mutex.notifyAll();
            }
        }
    }
}
