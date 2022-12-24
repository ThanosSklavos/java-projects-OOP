package gr.aueb.cf.ch11;

public class User {
    private static int usersCount = 0;
    private long id;
    private String username;
    private String password;

    public User() {
        usersCount++;
    }

    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        usersCount++;
    }

    static {
        usersCount++;
    }

    public static int getUsersCount() {
        return usersCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
