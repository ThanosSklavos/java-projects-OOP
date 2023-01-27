package gr.aueb.cf.ch18.accounts.service;

import gr.aueb.cf.ch18.accounts.dao.IAccountDAO;
import gr.aueb.cf.ch18.accounts.dto.AccountDTO;
import gr.aueb.cf.ch18.accounts.model.Account;
import gr.aueb.cf.ch18.accounts.model.Holder;
import gr.aueb.cf.ch18.accounts.service.exceptions.AccountIdAlreadyExistsException;
import gr.aueb.cf.ch18.accounts.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.ch18.accounts.service.exceptions.IbanAlreadyExistsException;
import gr.aueb.cf.ch18.accounts.service.exceptions.InsufficientBalanceException;

import java.util.List;

/**
 * The service layer class that implements the Decorator Pattern,
 * Delegation Pattern, Proxy Pattern (Wrapper Class of DAO).
 */
public class AccountServiceImpl implements IAccountService {

    private final IAccountDAO dao;

    public AccountServiceImpl(IAccountDAO dao){
        this.dao = dao;
    }

    @Override
    public Account insertAccount(AccountDTO accountDTO) throws IbanAlreadyExistsException, AccountIdAlreadyExistsException {
        Account account;
        try {
            account = new Account();
            mapAccount(account, accountDTO);

            if (dao.accountIdExists(accountDTO.getAccountID())) {
                throw new AccountIdAlreadyExistsException(account);
            }
            if (dao.ibanExists(accountDTO.getIban())) {
                throw new IbanAlreadyExistsException(account);
            }

            return dao.insert(account);

        } catch (IbanAlreadyExistsException | AccountIdAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account updateAccount(AccountDTO accountDTO) throws AccountNotFoundException {
        Account account;
        try {
            account = new Account();
            mapAccount(account, accountDTO);

            if (!dao.accountIdExists(accountDTO.getAccountID())) {
                throw new AccountNotFoundException(account);
            }
            if (!dao.ibanExists(accountDTO.getIban())) {
                throw new AccountNotFoundException(account);
            }

            return dao.update(account);

        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAccount(String iban) throws AccountNotFoundException {
        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            dao.delete(iban);

        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account getAccount(String iban) throws AccountNotFoundException {
        Account account;
        try {
            account = dao.get(iban);
            if (account == null) {
                throw new AccountNotFoundException(iban);
            }

            return account;

        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account getAccount(Long id) throws AccountNotFoundException {
        Account account;
        try {
            account = dao.get(id);
            if (account == null) {
                throw new AccountNotFoundException(id);
            }

            return account;

        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return dao.getAll();
    }

    @Override
    public void withdrawAmount(double amount, String iban, String ssn) throws AccountNotFoundException,
                                                                              InsufficientBalanceException {
        Account account;
        try {
            account = dao.get(iban);
            if (account == null) {
                throw new AccountNotFoundException(iban);
            }
            if (!account.getHolder().getSsn().equals(ssn)) {
                throw new AccountNotFoundException(ssn, iban);
            }
            if (amount <= 0) {
                throw new InsufficientBalanceException(account);
            }

            if (account.getBalance() < amount) {
                throw new InsufficientBalanceException(account);
            }

            dao.withdraw(amount, iban, ssn);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            e.printStackTrace();
            throw e;
        }

    }

    /**
     * Maps {@link AccountDTO} to {@link Account}.
     *
     * @param account
     *      the {@link Account} under creation.
     * @param accountDTO
     *      the {@link AccountDTO} transfer object.
     */
    private void mapAccount(Account account, AccountDTO accountDTO) {
        Holder holder = new Holder();
        holder.setId(accountDTO.getHolderDTO().getHolderID());
        holder.setFirstname(accountDTO.getHolderDTO().getFirstname());
        holder.setLastname(accountDTO.getHolderDTO().getLastname());
        holder.setSsn(accountDTO.getHolderDTO().getSsn());

        account.setHolder(holder);
        account.setId(accountDTO.getAccountID());
        account.setIban(accountDTO.getIban());
        account.setBalance(accountDTO.getBalance());
    }
}
