package gr.aueb.cf.ch11.exc1model;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(001, "Thanos", "Sklavos");
        UserCredentials user1Credentials = new UserCredentials(001, "thanso", "12345");

        printFields(user1, user1Credentials);
    }

    public static void printFields(User user, UserCredentials userCredentials) {
        System.out.println(user.getId() + " " + user.getFirstname() + " " + user.getLastname());
        System.out.println(userCredentials.getId() + " " + userCredentials.getUsername() + " " + userCredentials.getPassword());
    }
}
