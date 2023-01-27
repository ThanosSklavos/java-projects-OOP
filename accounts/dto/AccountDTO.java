package gr.aueb.cf.ch18.accounts.dto;

public class AccountDTO {
    private Long accountID;
    private HolderDTO holderDTO;
    private String iban;
    private double balance;

    public AccountDTO(){}

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public HolderDTO getHolderDTO() {
        return holderDTO;
    }

    public void setHolderDTO(HolderDTO holderDTO) {
        this.holderDTO = holderDTO;
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
        return "AccountDTO{" +
                "accountID=" + accountID +
                ", holderDTO=" + holderDTO +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
