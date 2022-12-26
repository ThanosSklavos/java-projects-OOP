package gr.aueb.cf.ch11.bankapp.model;

/**
 * Defines an {@link OverdraftAccount}.
 * <br>
 * @version 1.1
 * @since 0.1
 * @author Thanos
 */
public class OverdraftAccount {
    private final Long id;
    private final String iban;
    private final Holder holder;
    private double balance;
    private double overDraftBalance;   //borrowed money

    public OverdraftAccount() {
        id = 0L;
        iban = "";
        holder = new Holder();
        balance = 0;
        overDraftBalance = 0;
    }

    public OverdraftAccount(Long id, String iban, Holder holder, double balance,
                            double overDraftBalance) {
        this.id = id;
        this.iban = iban;
        this.holder = holder;
        this.balance = balance;
        this.overDraftBalance = overDraftBalance;
    }

    public Long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverDraftBalance() {
        return overDraftBalance;
    }

    public Holder getHolder() {
        return holder;
    }

    /**
     * Deposits a zero or positive amount of money
     * to account's balance.
     * @param amount
     *          the amount of money to be deposited
     * @throws Exception
     *          if the amount is negative
     */
    public void deposit(int amount) throws Exception {
        try {
            if (amount >= 0) {
                if (overDraftBalance == 0) {
                    balance += amount;
                } else if (overDraftBalance >= amount) {
                        overDraftBalance -= amount;
                        } else {
                    balance = amount - overDraftBalance;
                    overDraftBalance = 0;
                }
            } else throw new Exception("Negative amount Exception");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Withdraws a certain amount of money from
     * account's balance and lets holder borrow money
     * if amount is greater than balance
     * @param amount
     *          the amount to be withdrawn
     * @param ssn
     *          holder's ssn
     * @throws Exception
     *          if ssn is not valid
     */
    public void withdraw(int amount, String ssn) throws Exception {
        try {
            if (!ssnIsValid(ssn)) throw new Exception("Invalid ssn");
            if (amount > balance) {
                overDraftBalance += amount - balance;
                balance = 0;
            } else balance -= amount;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Returns the Account's state
     * @return
     *      Account's state
     */
    public String getAccountState() {
        return "(" + id + ", " + iban + ", " + holder.getInfo() + ", Balance = " + balance + ", borrowed money: "
                + overDraftBalance + ")";
    }

    private boolean ssnIsValid(String ssn) {
        return this.holder.getSsn().equals(ssn);
    }
}
