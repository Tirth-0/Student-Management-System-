package StudentManagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            showMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addUndergraduateStudent();
                    break;

                case 2:
                    addGraduateStudent();
                    break;

                case 3:
                    displayAllStudents();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    updateStudent();
                    break;

                case 6:
                    deleteStudent();
                    break;

                case 7:
                    System.out.println("\nThank you for using Student Management System.");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 7);

        scanner.close();
    }

    // Main menu
    public static void showMenu() {

        System.out.println("\n======================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM");
        System.out.println("======================================");
        System.out.println("1. Add Undergraduate Student");
        System.out.println("2. Add Graduate Student");
        System.out.println("3. Display All Students");
        System.out.println("4. Search Student");
        System.out.println("5. Update Student");
        System.out.println("6. Delete Student");
        System.out.println("7. Exit");
        System.out.println("======================================");
    }

    // Add undergraduate student
    public static void addUndergraduateStudent() {

        System.out.println("\n--- Add Undergraduate Student ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (studentExists(id)) {
            System.out.println("This Student ID already exists.");
            return;
        }

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("CGPA: ");
        double cgpa = scanner.nextDouble();

        System.out.print("Semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();

        UndergraduateStudent student =
                new UndergraduateStudent(
                        username,
                        name,
                        age,
                        id,
                        department,
                        cgpa,
                        semester
                );

        students.add(student);

        System.out.println("Undergraduate student added successfully.");
    }

    // Add graduate student
    public static void addGraduateStudent() {

        System.out.println("\n--- Add Graduate Student ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (studentExists(id)) {
            System.out.println("This Student ID already exists.");
            return;
        }

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("CGPA: ");
        double cgpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Research Topic: ");
        String researchTopic = scanner.nextLine();

        GraduateStudent student =
                new GraduateStudent(
                        username,
                        name,
                        age,
                        id,
                        department,
                        cgpa,
                        researchTopic
                );

        students.add(student);

        System.out.println("Graduate student added successfully.");
    }

    // Check whether a student ID already exists
    public static boolean studentExists(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {
                return true;
            }
        }

        return false;
    }

    // Display all students
    public static void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }

        System.out.println("\n========== ALL STUDENTS ==========");

        for (Student student : students) {

            System.out.println("----------------------------------");

            // Runtime polymorphism
            student.displayInfo();
            student.displayRole();
        }

        System.out.println("----------------------------------");
    }

    // Search student by ID
    public static void searchStudent() {

        System.out.print("\nEnter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {

            if (student.getStudentId() == id) {

                System.out.println("\nStudent Found!");
                System.out.println("----------------------------------");

                student.displayInfo();

                System.out.println("----------------------------------");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update department and CGPA
    public static void updateStudent() {

        System.out.print("\nEnter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {

            if (student.getStudentId() == id) {

                System.out.print("Enter new department: ");
                String department = scanner.nextLine();

                System.out.print("Enter new CGPA: ");
                double cgpa = scanner.nextDouble();
                scanner.nextLine();

                student.setDepartment(department);
                student.setCgpa(cgpa);

                System.out.println("Student information updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete student
    public static void deleteStudent() {

        System.out.print("\nEnter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getStudentId() == id) {

                students.remove(i);

                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}