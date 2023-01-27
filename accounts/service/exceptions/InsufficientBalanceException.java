package gr.aueb.cf.ch18.accounts.service.exceptions;

import gr.aueb.cf.ch18.accounts.model.Account;

public class InsufficientBalanceException extends Exception{
    private static final long serialVersionUID = 1L;

    public InsufficientBalanceException(Account account) {
        super("Insufficient balance: " + account.getBalance());
    }
}
