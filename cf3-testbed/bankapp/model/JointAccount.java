package gr.aueb.cf.ch11.bankapp.model;

/**
 * Defines a {@link JointAccount} with two holders.
 * <br>
 * @version 1.0
 * @since 0.1
 * @author  Thanos
 */
public class JointAccount {
    private final Long id;
    private final String iban;
    private final String firstname1;
    private final String lastname1;
    private final String ssn1;
    private final String firstname2;
    private final String lastname2;
    private final String ssn2;
    private double balance;


    public JointAccount() {
        id = 0L;
        iban = "";
        firstname1 = "";
        lastname1 = "";
        ssn1 = "";
        firstname2 = "";
        lastname2 = "";
        ssn2 = "";
        balance = 0;
    }

    public JointAccount(Long id, String iban, String firstname,
                        String lastname, String ssn, String firstname2,
                        String lastname2, String ssn2, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstname1 = firstname;
        this.lastname1 = lastname;
        this.ssn1 = ssn;
        this.firstname2 = firstname2;
        this.lastname2 = lastname2;
        this.ssn2 = ssn2;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public String getFirstname1() {
        return firstname1;
    }

    public String getLastname1() {
        return lastname1;
    }

    public String getSsn1() {
        return ssn1;
    }

    public String getFirstname2() {
        return firstname2;
    }

    public String getLastname2() {
        return lastname2;
    }

    public String getSsn2() {
        return ssn2;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        return "(" + id + ", " + iban + ", " + firstname1 + ", "
                + lastname1 + ", " + ssn1 + ", " + firstname2 + ", "
                + lastname2 + ", " + ssn2 + ", Balance = " + balance + ")";
    }

    private boolean ssnIsValid(String ssn) {
        return (this.ssn1.equals(ssn)) || (this.ssn2.equals(ssn));
    }
}
