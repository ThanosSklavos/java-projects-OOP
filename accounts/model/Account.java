package gr.aueb.cf.ch18.accounts.model;

public class Account extends AbstractEntity {
    private Holder holder;
    private String iban;
    private double balance;

    public Account(){}

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID= " + getId() +
                "," + holder +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        //if (Double.compare(account.getBalance(), getBalance()) != 0) return false;
        //if (!getHolder().equals(account.getHolder())) return false;
        return getId().equals(account.getId());
    }

    @Override
    public int hashCode() {
        /*int result;
        long temp;
        result = getHolder().hashCode();
        result = 31 * result + getIban().hashCode();
        temp = Double.doubleToLongBits(getBalance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));*/
        return getId().hashCode();
    }
}
