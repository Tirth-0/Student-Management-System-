package StudentManagementsystem;

public class GraduateStudent extends Student {

    private String researchTopic;

    public GraduateStudent(String username, String name, int age,
                           int studentId, String department,
                           double cgpa, String researchTopic) {
        super(username, name, age, studentId, department, cgpa);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: Graduate");
        super.displayInfo();
        System.out.println("Research Topic: " + researchTopic);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Graduate Student");
    }
}