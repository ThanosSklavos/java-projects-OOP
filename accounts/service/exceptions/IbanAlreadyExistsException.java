package gr.aueb.cf.ch18.accounts.service.exceptions;

import gr.aueb.cf.ch18.accounts.model.Account;

public class IbanAlreadyExistsException extends Exception{
    private final static long serialVersionUID = 1L;

    public IbanAlreadyExistsException(Account account) {
        super("Account with iban " + account.getIban() + " already exists");
    }
}
