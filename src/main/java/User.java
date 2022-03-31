public class User {
    private String firstName;
    private String lastName;
    private int age;
    public User(String name, String surname, String eta) {
        this.firstName = name;
        this.lastName = surname;
        this.age = Integer.parseInt(eta);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAge() {
        return String.valueOf(this.age);
    }

    @Override
    public String toString() {
        return "FirstName= " + firstName + '\n' +
                "LastName= " + lastName + '\n' +
                "Age= " + age;
    }
}
