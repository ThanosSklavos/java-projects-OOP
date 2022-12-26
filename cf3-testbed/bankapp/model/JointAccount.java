package gr.aueb.cf.ch11.bankapp.model;

/**
 * Defines a {@link JointAccount} with two holders.
 * <br>
 * @version 1.1
 * @since 0.1
 * @author  Thanos
 */
public class JointAccount {
    private final Long id;
    private final String iban;
    private final Holder holder1;
    private final Holder holder2;
    private double balance;


    public JointAccount() {
        id = 0L;
        iban = "";
        holder1 = new Holder();
        holder2 = new Holder();
        balance = 0;
    }

    public JointAccount(Long id, String iban, Holder holder1, Holder holder2, double balance) {
        this.id = id;
        this.iban = iban;
        this.holder1 = holder1;
        this.holder2 = holder2;
        this.balance = balance;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Holder getHolder1() {
        return holder1;
    }

    public Holder getHolder2() {
        return holder2;
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
                balance += amount;
            } else throw new Exception("Negative amount Exception");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Withdraws a certain amount of money from
     * account's balance.
     * @param amount
     *          the amount to be withdrawn
     * @param ssn
     *          holder's ssn
     * @throws Exception
     *          if the amount is greater than
     *          account's balance or ssn is not valid
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!ssnIsValid(ssn)) throw new Exception("Ssn not valid exception");
            if (amount <= balance) {
                balance -= amount;
            } else {
                throw new Exception("Insufficient balance exception");
            }
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
        return "(" + id + ", " + iban + ", " +holder1.getInfo() + ", " + holder2.getInfo() + ", Balance = " + balance + ")";
    }

    private boolean ssnIsValid(String ssn) {
        return (this.holder1.getSsn().equals(ssn)) || (this.holder2.getSsn().equals(ssn));
    }
}
