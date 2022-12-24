package gr.aueb.cf.ch11;

/**
 *  Student class definition.
 *  POJO class (Plain Old Java Object)
 *  Javabean
 */
public class Student {
    private int id;
    private String firstname;   // Πεδία/Fields, Μέλη της κλάσης
    private String lastname;

    public Student() {
    }

    public Student(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
