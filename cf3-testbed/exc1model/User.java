package gr.aueb.cf.ch11.exc1model;

/**
 * Defines a {@link User} class
 *
 * @author Thanos
 * @version 1.0
 * @since  0.1
 */
public class User {
    private long id;
    private String firstname;
    private String lastname;

    public User() {
    }

    public User(long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}