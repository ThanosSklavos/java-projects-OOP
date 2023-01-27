package gr.aueb.cf.ch18.accounts.dao;

import gr.aueb.cf.ch18.accounts.model.Account;

import java.util.List;

public interface IAccountDAO {

    /**
     * Inserts a new {@link Account} instance in the datasource.
     *
     * @param account
     *      the model object that contains the account data.
     * @return
     *      the inserted {@link Account}
     */
    Account insert(Account account);

    /**
     * Updates an {@link Account} instance of the datasource.
     *
     * @param account
     *      the model object that contains the account data.
     * @return
     *      the {@link Account} instance before the update.
     */
    Account update(Account account);

    /**
     * Removes an {@link Account} instance from the datasource.
     *
     * @param iban
     *      the iban of the {@link Account} to be removed.
     * @return
     *      the iban of the {@link Account} that was removed.
     */
    void delete(String iban);

    /**
     * Returns an {@link Account} based on the input id
     * @param id
     *          the {@link Account#id} of the instance
     *          to be returned
     */
    Account get(Long id);

    /**
     * Returns an {@link Account} based on the input iban
     * @param iban
     *          the {@link Account#iban} of the instance
     *          to be returned
     * @return
     *          the resulting {@link Account}
     */
    Account get(String iban);

    /**
     * Returns all the {@link Account} instances from the
     * datasource.
     * @return
     *          the resulting {@link List<Account>}
     */
    List<Account> getAll();

    /**
     * Withdraws the amount from the {@link Account#balance}.
     *
     * @param amount
     *      the amount that will be withdrawn from the {@link Account#balance}.
     *
     * @param iban
     *      the {@link Account#iban} from which the amount will
     *      be withdrawn.
     *
     * @param ssn
     *      the {@link Account#holder#ssn} from which the amount will
     *      be withdrawn.
     * @return
     *      the withdrawn amount
     */
    void withdraw(double amount, String iban, String ssn);

    /**
     * Checks if an <code>id</code> already exists as part
     * of the {@link Account}
     * @param id
     *           the <code>id</code> to be searched for,
     */
    boolean accountIdExists(Long id);

    /**
     * Checks if an iban already exists as part
     * of the {@link Account}
     * @param iban
     *                  the <code>iban</code> to be searched for,
     * @return
     *          true, if <code>iban</code> exists in a
     *          {@link Account} in the datasource
     */
    boolean ibanExists(String iban);
}
