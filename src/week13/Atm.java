package shelpam.week13;

public class Atm {
    public void change(Account account, int delta) {
        synchronized (account) {
            account.setBalance(account.getBalance() + delta);
        }
    }
}
