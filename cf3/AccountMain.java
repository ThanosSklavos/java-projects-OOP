package gr.aueb.cf.ch11;

public class AccountMain {

    public static void main(String[] args) {
        Account alice = new Account(1, "GR1234", "Alice", "W.", "R123", 100.5);
        Account bob = new Account();

        bob.setBalance(100000);
        bob.setId(2);
        bob.setFirstname("Bob");
        bob.setLastname("Dylan");
        bob.setIban("GR1235");
        bob.setSsn("A123");
        try {
            bob.withdraw(10000, "A123");
            bob.deposit(20000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bob.getAccountState());


        try {
            alice.deposit(1100);
            System.out.println("Successful Deposit");

            alice.withdraw(400, "R123");
            System.out.println("Successful Withdrawal");

            System.out.println("Alice Balance: " + alice.getAccountBalance());
            System.out.println(alice.getAccountState());

            alice.withdraw(200, "R456");
            System.out.println("Successful Withdrawal");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
