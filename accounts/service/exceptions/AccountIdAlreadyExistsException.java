package gr.aueb.cf.ch18.accounts.service.exceptions;

import gr.aueb.cf.ch18.accounts.model.Account;

public class AccountIdAlreadyExistsException extends Exception{
    private final static long serialVersionUID = 1L;

    public AccountIdAlreadyExistsException(Account account) {
        super("Account with id " + account.getId() + " already exists");
    }
}
