package shelpam.week14;

public class Accumulator extends Thread {
    private int[] data;
    private int l, r;
    private int result = 0;

    public Accumulator(int[] data, int l, int r) {
        this.data = data;
        this.l = l;
        this.r = r;
    }

    public int getResult() {
        return this.result;
    }

    @Override
    public void run() {
        for (int i = l; i != r; ++i) {
            result += data[i];
        }
    }
}
