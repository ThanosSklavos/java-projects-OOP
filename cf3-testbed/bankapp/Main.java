package gr.aueb.cf.ch11.bankapp;

import gr.aueb.cf.ch11.bankapp.model.JointAccount;
import gr.aueb.cf.ch11.bankapp.model.OverdraftAccount;

/**
 * Driver to test {@link JointAccount} and
 * {@link OverdraftAccount} classes.
 * <br>
 * @author Thanos
 *
 */
public class Main {
    public static void main(String[] args) {
        OverdraftAccount overdraftAccount = new OverdraftAccount(1L, "GR1234", "Thanos",
                                                        "Sklavos", "A123", 1500, 0);

        JointAccount jointAccount = new JointAccount(1L, "GR1234", "Thanos", "Sklavos", "A123",
                                                        "Than", "S.", "B456", 3000);

        System.out.println("OverdraftAccount features test");
        overdraftAccountTest(overdraftAccount);

        System.out.println("JointAccount features test");
        jointAccountTest(jointAccount);

    }

    public static void overdraftAccountTest(OverdraftAccount overdraftAccount) {
        System.out.println(overdraftAccount.getAccountState());
        try {
            overdraftAccount.withdraw(2000, "A123");
            System.out.println(overdraftAccount.getAccountState());
            overdraftAccount.withdraw(500, "A123");
            System.out.println(overdraftAccount.getAccountState());
            overdraftAccount.deposit(3000);
            System.out.println(overdraftAccount.getAccountState());
            overdraftAccount.withdraw(500, "A123");
            System.out.println(overdraftAccount.getAccountState());
            overdraftAccount.withdraw(5000, "A123");
            System.out.println(overdraftAccount.getAccountState());
            overdraftAccount.deposit(3000);
            System.out.println(overdraftAccount.getAccountState());
            overdraftAccount.deposit(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jointAccountTest(JointAccount jointAccount) {
        System.out.println(jointAccount.getAccountState());
        try {
            jointAccount.deposit(3000);
            jointAccount.withdraw(5000, "A123");
            jointAccount.withdraw(3500, "B456");
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(jointAccount.getAccountState());
    }
}
