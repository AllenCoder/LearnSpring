package hello;

/**
 * Created by Allen on 2017/6/29.
 */
public class Person {

    private String lastName;
    private String firstName;
//Caused by: java.lang.NoSuchMethodException: hello.Person.<init>()


    public Person() {
    }

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
