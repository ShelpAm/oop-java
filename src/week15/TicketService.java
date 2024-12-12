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
        for (int i = 0; i != count; ++i) {
            synchronized (mutex) {
                thisBooked[i] = tickets[soldOuts++];
            }
        }
        return thisBooked;
    }
}
