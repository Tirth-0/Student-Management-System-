package StudentManagementsystem;

public class UndergraduateStudent extends Student {

    private String semester;

    public UndergraduateStudent(String username, String name, int age,
                                int studentId, String department,
                                double cgpa, String semester) {

        super(username, name, age, studentId, department, cgpa);
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Type: Undergraduate");
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + getDepartment());
        System.out.println("CGPA: " + getCgpa());
        System.out.println("Semester: " + semester);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Undergraduate Student");
    }
}