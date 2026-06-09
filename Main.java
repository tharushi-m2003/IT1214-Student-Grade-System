import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Average Marks");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");
            int choice = input.nextInt();

            if (choice == 1) {

                addStudent(input);

            } else if (choice == 2) {

                displayStudents();

            } else if (choice == 3) {

                searchStudent(input);

            } else if (choice == 4) {

                averageMarks();

            } else if (choice == 5) {

                System.exit(0);

            } else {

                System.out.println("Invalid Choice");

            }

        }

    }

    public static void addStudent(Scanner input) {

        System.out.print("Enter Student ID : ");
        int id = input.nextInt();

        input.nextLine();

        System.out.print("Enter Student Name : ");
        String name = input.nextLine();

        System.out.print("Enter Marks : ");
        double marks = input.nextDouble();

        Student student = new Student(id, name, marks);

        students.add(student);

        System.out.println("Student Added Successfully.");

    }

    public static void displayStudents() {

        if (students.isEmpty()) {

            System.out.println("No Students Found");

            return;

        }

        for (Student s : students) {

            System.out.println("------------------------");
            System.out.println("ID : " + s.getStudentId());
            System.out.println("Name : " + s.getStudentName());
            System.out.println("Marks : " + s.getMarks());

        }

    }

    public static void searchStudent(Scanner input) {

        System.out.print("Enter Student ID : ");

        int id = input.nextInt();

        for (Student s : students) {

            if (s.getStudentId() == id) {

                System.out.println("ID : " + s.getStudentId());
                System.out.println("Name : " + s.getStudentName());
                System.out.println("Marks : " + s.getMarks());

                return;

            }

        }

        System.out.println("Student Not Found");

    }

    public static void averageMarks() {

        if (students.isEmpty()) {

            System.out.println("No Students");

            return;

        }

        double total = 0;

        for (Student s : students) {

            total += s.getMarks();

        }

        double average = total / students.size();

        System.out.println("Average Marks = " + average);

    }

}