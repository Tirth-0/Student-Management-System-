package StudentManagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Undergraduate");
            System.out.println("2. Add Graduate");
            System.out.println("3. Display All");
            System.out.println("4. Search");
            System.out.println("5. Update");
            System.out.println("6. Delete");
            System.out.println("7. Exit");

            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addUndergraduate();
                case 2 -> addGraduate();
                case 3 -> displayAll();
                case 4 -> search();
                case 5 -> update();
                case 6 -> delete();
                case 7 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    static String getName() {
        while (true) {
            System.out.print("Name: ");
            String name = sc.nextLine();

            if (name.matches("[a-zA-Z ]+"))
                return name;

            System.out.println("Name can contain letters and spaces only.");
        }
    }

    static double getCgpa() {
        while (true) {
            System.out.print("CGPA (0.00 - 4.00): ");
            double cgpa = sc.nextDouble();

            if (cgpa >= 0 && cgpa <= 4)
                return cgpa;

            System.out.println("CGPA must be between 0.00 and 4.00.");
        }
    }

    static String getSemester() {
        while (true) {
            System.out.print("Semester (1st - 12th): ");
            String semester = sc.nextLine().trim().toLowerCase();

            if (semester.matches(
                    "(1st|2nd|3rd|4th|5th|6th|7th|8th|9th|10th|11th|12th)"))
                return semester;

            System.out.println("Enter a valid semester from 1st to 12th.");
        }
    }

    static boolean exists(int id) {
        for (Student s : students)
            if (s.getStudentId() == id)
                return true;

        return false;
    }

    static void addUndergraduate() {

        System.out.println("\n--- Add Undergraduate ---");

        System.out.print("Username: ");
        String username = sc.nextLine();

        String name = getName();

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (exists(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Department: ");
        String department = sc.nextLine();

        double cgpa = getCgpa();
        sc.nextLine();

        String semester = getSemester();

        students.add(new UndergraduateStudent(
                username, name, age, id, department, cgpa, semester));

        System.out.println("Student added successfully!");
    }

    static void addGraduate() {

        System.out.println("\n--- Add Graduate ---");

        System.out.print("Username: ");
        String username = sc.nextLine();

        String name = getName();

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (exists(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Department: ");
        String department = sc.nextLine();

        double cgpa = getCgpa();
        sc.nextLine();

        System.out.print("Research Topic: ");
        String topic = sc.nextLine();

        students.add(new GraduateStudent(
                username, name, age, id, department, cgpa, topic));

        System.out.println("Student added successfully!");
    }

    static void displayAll() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println("\n--------------------");
            s.displayInfo();
            s.displayRole();
        }
    }

    static void search() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getStudentId() == id) {
                s.displayInfo();
                s.displayRole();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void update() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.getStudentId() == id) {

                System.out.print("New Department: ");
                s.setDepartment(sc.nextLine());

                double cgpa = getCgpa();
                sc.nextLine();

                s.setCgpa(cgpa);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void delete() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getStudentId() == id) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}