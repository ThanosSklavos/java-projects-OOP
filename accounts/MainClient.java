package gr.aueb.cf.ch18.accounts;

import gr.aueb.cf.ch18.accounts.dao.AccountDAOImpl;
import gr.aueb.cf.ch18.accounts.dto.AccountDTO;
import gr.aueb.cf.ch18.accounts.dto.HolderDTO;
import gr.aueb.cf.ch18.accounts.model.Account;
import gr.aueb.cf.ch18.accounts.service.AccountServiceImpl;
import gr.aueb.cf.ch18.accounts.service.IAccountService;
import gr.aueb.cf.ch18.accounts.service.exceptions.AccountIdAlreadyExistsException;
import gr.aueb.cf.ch18.accounts.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.ch18.accounts.service.exceptions.IbanAlreadyExistsException;
import gr.aueb.cf.ch18.accounts.service.exceptions.InsufficientBalanceException;

public class MainClient {

    public static void main(String[] args) throws AccountIdAlreadyExistsException, IbanAlreadyExistsException,
                                                  AccountNotFoundException, InsufficientBalanceException {
        AccountDAOImpl accountDAO = new AccountDAOImpl();
        AccountServiceImpl accountService = new AccountServiceImpl(accountDAO);

        AccountDTO accountDTO1 = new AccountDTO();
        AccountDTO accountDTO2 = new AccountDTO();
        AccountDTO accountDTO3 = new AccountDTO();
        AccountDTO accountDTO4 = new AccountDTO();


        setAccountDTO(accountDTO1, 1L, "GR1234",10L,"Thanos",
                "Sklavos", "1234",10000);
        setAccountDTO(accountDTO2, 2L, "GR4321",20L,"Than",
                "Skl.", "4321",20000);
        setAccountDTO(accountDTO3, 3L, "GR5678",30L,"T.",
                "S.", "5678",30000);

         setAccountDTO(accountDTO4, 2L, "GR4321",30L,"Nick",
                "Papadopoulos", "5678",20000);

        accountService.insertAccount(accountDTO1);
        accountService.insertAccount(accountDTO2);
        accountService.insertAccount(accountDTO3);
        printData(accountService);

        accountService.deleteAccount("GR5678");
        System.out.println(accountService.getAccount(1L));
        System.out.println(accountService.getAccount("GR4321"));
        accountService.updateAccount(accountDTO4);

        accountService.withdrawAmount(100.5, "GR1234", "1234");
        accountService.depositAmount(2000 , "GR4321");

        printData(accountService);

    }

    public static AccountDTO setAccountDTO(AccountDTO accountDTO,Long accountID, String iban,
                                           Long holderID, String firstname, String lastname, String ssn,
                                           double balance){
        HolderDTO holderDTO = new HolderDTO();

        holderDTO.setHolderID(holderID);
        holderDTO.setSsn(ssn);
        holderDTO.setLastname(lastname);
        holderDTO.setFirstname(firstname);

        accountDTO.setHolderDTO(holderDTO);
        accountDTO.setIban(iban);
        accountDTO.setAccountID(accountID);
        accountDTO.setBalance(balance);

        return accountDTO;
    }

    public static void printData(IAccountService accountService) {
        System.out.println();
        for (Account a : accountService.getAllAccounts()) {
            System.out.println(a);
        }
        System.out.println();
    }

}
