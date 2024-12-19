package shelpam.week14;

import java.util.ArrayList;
import java.util.List;

public class State implements Runnable {
    private final int currentState;
    private int nextState;
    private List<State> previousStates = new ArrayList<State>();
    private String work;
    private Object mutex;
    private FiniteStateMachine fsm;

    public State(int currentState, int nextState, String work) {
        this.currentState = currentState;
        this.nextState = nextState;
        this.work = work;
    }

    public void setMutex(Object mutex) {
        this.mutex = mutex;
    }

    public void setFSM(FiniteStateMachine fsm) {
        this.fsm = fsm;
    }

    public void addPreviousState(State s) {
        previousStates.add(s);
    }

    @Override
    public void run() {
        var s = work.toCharArray();
        int i = 0;
        for (char c : s) {
            synchronized (this.mutex) {
                while (fsm.getCurrentState() != currentState) {
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
                if (++i == s.length) {
                    forwardExecutionTo(nextState);
                }
                fsm.setState(nextState);
                mutex.notifyAll();
            }
        }
    }

    public int getNextState() {
        return nextState;
    }

    public int getCurrentState() {
        return currentState;
    }

    private void setNextState(int state) {
        nextState = state;
    }

    // This approach is slow. A better solution may be running in a DSU-like
    // structure.
    //
    // * DSU is disjoint set union, a data structure.
    private void forwardExecutionTo(int state) {
        for (var prev : previousStates) {
            prev.setNextState(state);
        }
    }
}
