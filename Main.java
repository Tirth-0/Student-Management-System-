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

        String name;

        // Name validation
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine();

            if (name.matches("[a-zA-Z ]+")) {
                break;
            }

            System.out.println(
                    "Invalid name! Please use alphabetic characters only."
            );
        }

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

        double cgpa;

        // CGPA validation
        while (true) {
            System.out.print("CGPA (0.00 - 4.00): ");
            cgpa = scanner.nextDouble();

            if (cgpa >= 0 && cgpa <= 4) {
                break;
            }

            System.out.println(
                    "Invalid CGPA! Please enter a value between 0.00 and 4.00."
            );
        }

        scanner.nextLine();

        String semester;

        // Semester validation
        while (true) {
            System.out.print("Semester (1st - 12th): ");
            semester = scanner.nextLine().trim().toLowerCase();

            if (isValidSemester(semester)) {
                break;
            }

            System.out.println(
                    "Invalid semester! Please enter from 1st to 12th."
            );
        }

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

        String name;

        // Name validation
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine();

            if (name.matches("[a-zA-Z ]+")) {
                break;
            }

            System.out.println(
                    "Invalid name! Please use alphabetic characters only."
            );
        }

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

        double cgpa;

        // CGPA validation
        while (true) {
            System.out.print("CGPA (0.00 - 4.00): ");
            cgpa = scanner.nextDouble();

            if (cgpa >= 0 && cgpa <= 4) {
                break;
            }

            System.out.println(
                    "Invalid CGPA! Please enter a value between 0.00 and 4.00."
            );
        }

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

    // Check valid semester
    public static boolean isValidSemester(String semester) {

        switch (semester) {

            case "1st":
            case "2nd":
            case "3rd":
            case "4th":
            case "5th":
            case "6th":
            case "7th":
            case "8th":
            case "9th":
            case "10th":
            case "11th":
            case "12th":
                return true;

            default:
                return false;
        }
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

                double cgpa;

                // CGPA validation during update
                while (true) {
                    System.out.print("Enter new CGPA (0.00 - 4.00): ");
                    cgpa = scanner.nextDouble();

                    if (cgpa >= 0 && cgpa <= 4) {
                        break;
                    }

                    System.out.println(
                            "Invalid CGPA! Please enter a value between 0.00 and 4.00."
                    );
                }

                scanner.nextLine();

                student.setDepartment(department);
                student.setCgpa(cgpa);

                System.out.println(
                        "Student information updated successfully."
                );

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