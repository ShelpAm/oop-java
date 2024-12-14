package shelpam.week15;

/**
 * TicketService
 */
public class TicketService {
    private int[] tickets;
    private int soldOuts;
    Object mutex = new Object();

    public TicketService() {
        tickets = new int[30];
    }

    // Assume count is between 1 to 5.
    public int[] book(int count) {
        int[] thisBooked = new int[count];

        // Prefetches the tickets.
        synchronized (mutex) {
            soldOuts += count;
        }

        for (int i = soldOuts - count, j = 0; i != soldOuts; ++i) {
            thisBooked[j++] = i;
        }

        return thisBooked;
    }
}
