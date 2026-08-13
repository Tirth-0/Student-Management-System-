package StudentManagementsystem;

public class Student extends Person {

    private int studentId;
    private String department;
    private double cgpa;

    public Student(String username, String name, int age,
                   int studentId, String department, double cgpa) {

        super(username, name, age);

        this.studentId = studentId;
        this.department = department;
        this.cgpa = cgpa;
    }

    // Getter methods

    public int getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }

    public double getCgpa() {
        return cgpa;
    }

    // Setter methods

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

    // Method overloading
    public void displayInfo(boolean showUsername) {
        displayInfo();

        if (showUsername) {
            System.out.println("Username: " + getUsername());
        }
    }
}