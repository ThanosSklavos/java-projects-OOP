package gr.aueb.cf.ch18.accounts.service.exceptions;

import gr.aueb.cf.ch18.accounts.model.Account;

public class AccountNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public AccountNotFoundException(String iban) {
        super("The account with iban " + iban + " was not found");
    }

    public AccountNotFoundException(String ssn, String iban) { super("The account with ssn " + ssn +
                                                                    " and iban " + iban + " was not found");}

    public AccountNotFoundException(Long id) {
        super("The account with id " + id + " was not found");
    }


    public AccountNotFoundException(Account account) {
        super("The account with id " + account.getId() + " and iban "
                + account.getIban() + " was not found");
    }
}
