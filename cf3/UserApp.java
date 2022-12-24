package gr.aueb.cf.ch11;

public class UserApp {

    public static void main(String[] args) {
        User alice = new User();
        User bob = new User();
        User chris = new User(3L, "Chris", "R.");

        System.out.println(User.getUsersCount());
    }
}
