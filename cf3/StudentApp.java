package gr.aueb.cf.ch11;

public class StudentApp {

    public static void main(String[] args) {
        Student alice = new Student();  //Student()  ---> default constructor (parameterless)
        Student bob = new Student(2, "Bob", "Dylan");  //cntr+p shows parameters

        System.out.println("ID: " + bob.getId());
        System.out.println("Firstname: " + bob.getFirstname());
        System.out.println("Lastname: " + bob.getLastname());

        /*//Set
        alice.id = 1;                    //Instance (στιγμιότυπο) of Student
        alice.firstname = "Alice";
        alice.lastname = "W";            //State of instance : 1, Alice, W

        //Get
        System.out.println("IDL " + alice.id);
        System.out.println("Firstname: " + alice.firstname);
        System.out.println("Lastname: " + alice.lastname);*/


        alice.setId(1);
        alice.setFirstname("Alice");
        alice.setLastname("W");

        System.out.println("Id: " + alice.getId());
    }
}
