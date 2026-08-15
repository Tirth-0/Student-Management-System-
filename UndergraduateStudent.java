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
        System.out.println("Type: Undergraduate");
        super.displayInfo();
        System.out.println("Semester: " + semester);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Undergraduate Student");
    }
}