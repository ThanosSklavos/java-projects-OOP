package gr.aueb.cf.ch18.accounts.dao;

import gr.aueb.cf.ch18.accounts.model.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * The DAO layer class that implements the Proxy Design Pattern
 */
public class AccountDAOImpl implements IAccountDAO {
    private static final List<Account> accounts = new ArrayList<>();

    @Override
    public Account insert(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(Account account) {
        return accounts.set(accounts.indexOf(account), account);
    }

    @Override
    public void delete(String iban) {
        accounts.removeIf( accounts -> accounts.getIban().equals(iban));
    }

    @Override
    public Account get(Long id) {
        int pos = getIndexById(id);
        if (pos == -1) return null;
        return accounts.get(pos);
    }

    @Override
    public Account get(String iban) {
        int pos = getIndexByIban(iban);
        if (pos == -1) return null;
        return accounts.get(pos);
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }

    @Override
    public boolean accountIdExists(Long id) {
        return getIndexById(id) != -1;
    }

    @Override
    public boolean ibanExists(String iban) {
        return getIndexByIban(iban) != -1;
    }

    @Override
    public void withdraw(double amount, String iban, String ssn) {
        int pos = getIndexByIban(iban);

        accounts.get(pos).setBalance(accounts.get(pos).getBalance() - amount);
    }

    @Override
    public void deposit(double amount, String iban) {
        int pos = getIndexByIban(iban);

        accounts.get(pos).setBalance(accounts.get(pos).getBalance() + amount);
    }

    /**
     * Returns the position in the ArrayList datasource
     * of the {@link Account} containing the <code>id</code>.
     *
     * @param id
     *          the {@link Account#id} to be searched.
     * @return
     *          the resulting position, or -1 if
     *          the id will not be found.
     */
    private int getIndexById(Long id) {
        int pos = -1;
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getId().equals(id)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    /**
     * Returns the position in the ArrayList datasource
     * of the {@link Account} containing the <code>iban</code>.
     *
     * @param iban
     *          the {@link Account#id} to be searched.
     * @return
     *          the resulting position, or -1 if
     *          the iban will not be found.
     */
    private int getIndexByIban(String iban) {
        int pos = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getIban().equals(iban)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
