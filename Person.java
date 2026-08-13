package StudentManagementsystem;

public class Person extends User {

    protected String name;
    protected int age;

    public Person(String username, String name, int age) {
        super(username);
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Person");
    }
}