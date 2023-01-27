package gr.aueb.cf.ch18.accounts.service;

import gr.aueb.cf.ch18.accounts.dto.AccountDTO;
import gr.aueb.cf.ch18.accounts.model.Account;
import gr.aueb.cf.ch18.accounts.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.ch18.accounts.service.exceptions.IbanAlreadyExistsException;
import gr.aueb.cf.ch18.accounts.service.exceptions.AccountIdAlreadyExistsException;
import gr.aueb.cf.ch18.accounts.service.exceptions.InsufficientBalanceException;

import java.util.List;

public interface IAccountService {

    /**
     * Creates an {@link Account} based on the data carried
     * by the {@link AccountDTO}.
     *
     * @param accountDTO
     *      the DTO object that contains the account data.
     * @return
     *      the resulting {@link Account}
     * @throws IbanAlreadyExistsException
     *      if the {@link Account#iban} already exists
     *      in the data source.
     * @throws AccountIdAlreadyExistsException
     *      if the {@link Account#id} already exists
     *      in the data source.
     */
    Account insertAccount(AccountDTO accountDTO)
            throws IbanAlreadyExistsException, AccountIdAlreadyExistsException;

    /**
     * Updates an {@link Account} based on the data carried
     * by the {@link AccountDTO}.
     * @param accountDTO
     *          the DTO object that contains the account data.
     * @return
     *          the {@link Account} before the update.
     *
     * @throws AccountNotFoundException
     *          if {@link AccountDTO#accountID,#iban} does not map
     *          to an {@link Account} in the datasource.
     */
    Account updateAccount(AccountDTO accountDTO)
            throws AccountNotFoundException, IbanAlreadyExistsException;

    /**
     * Removes an {@link Account}.
     *
     * @param iban
     *          the {@link Account#iban} needed to be removed.
     * @throws AccountNotFoundException
     *          if {@link Account#iban} does not map
     *          to an {@link Account} in the datasource.
     */
    void deleteAccount(String iban)
            throws AccountNotFoundException;

    /**
     * Returns the {@link Account} based on the input iban.
     * @param iban
     *          the {@link Account#iban} of the account instance
     *          needed to be retured.
     * @return
     *          the resulting {@link Account}.
     * @throws AccountNotFoundException
     *          if {@link Account#iban} does not map
     *          to a {@link Account} in the datasource.
     */
    Account getAccount(String iban)
            throws AccountNotFoundException;

    /**
     * Returns the {@link Account} based on the input id.
     * @param id
     *          the {@link Account#id} of the account instance
     *          needed to be returned.
     * @return
     *          the resulting {@link Account}.
     * @throws AccountNotFoundException
     *          if {@link Account#id} does not map
     *          to an {@link Account} in the datasource.
     */
    Account getAccount(Long id)
            throws AccountNotFoundException;

    /**
     * Returns all the {@link Account} instances of the datasource.
     *
     * @return
     *      the resulting {@link List<Account>}.
     */
    List<Account> getAllAccounts();

    /**
     * Withdraws the amount from the {@link Account} balance.
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
     *
     * @throws InsufficientBalanceException
     *      if {@link Account} balance is less than the amount.
     *
     * @throws AccountNotFoundException
     *          if {@link Account#iban} or {@link Account#holder#ssn} does not map
     *          to a {@link Account} in the datasource.
     */
    void withdrawAmount(double amount, String iban, String ssn) throws InsufficientBalanceException,
                                                                        AccountNotFoundException;
}
