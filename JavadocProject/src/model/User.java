package model;

/**
 * Defines a {@link User} type.
 *
 * @version 1.0
 * @since 0.1
 * @author Thanos
 */
public class User {
    private int id;
    private String username;
    private String password;

    /**
     * Creates a default user with
     * 0 id and null username and
     * password.
     */
    public User() {}

    /**
     * Sets user id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user's username
     * @return  user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets user's username
     * @param username
     *          user username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get user's password
     * @return  user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets user's password
     * @param password
     *          user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
