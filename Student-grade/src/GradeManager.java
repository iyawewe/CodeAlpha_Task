import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class GradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Enter number of students:");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        // Input student marks
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine();

            students.add(new Student(name, grade));
        }

        // Calculations
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = total / students.size();

        // Summary Report
        System.out.println("\n------ Student Grades Summary ------");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.grade);
        }

        System.out.println("------------------------------------");
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Grade : " + lowest + " (by " + lowStudent + ")");
    }
}
