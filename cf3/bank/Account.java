package gr.aueb.cf.ch11.bank;

/**
 * Defines a bank account.
 *
 * @author Thanos
 */
public final class Account {
    private final Holder holder;
    private String iban;
    private double balance;

    public Account() {
        holder = new Holder();
        iban = "";
    }

    public Account(Holder holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

    public Holder getHolder() {
        return holder;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
