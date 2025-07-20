import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class GradeTracker {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        tracker.run();
    }

    public void run() {
        System.out.println("=== Student Grade Tracker ===");
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    calculateStatistics();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Calculate Statistics");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        
        students.add(new Student(name, grade));
        System.out.println("Student added successfully!");
    }

    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        
        System.out.println("\n=== Student List ===");
        System.out.printf("%-20s %-10s%n", "Name", "Grade");
        System.out.println("-------------------- ----------");
        
        for (Student student : students) {
            System.out.printf("%-20s %-10.2f%n", 
                student.getName(), student.getGrade());
        }
    }

    private void calculateStatistics() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate statistics.");
            return;
        }
        
        double sum = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        
        for (Student student : students) {
            double grade = student.getGrade();
            sum += grade;
            
            if (grade > highest) {
                highest = grade;
            }
            
            if (grade < lowest) {
                lowest = grade;
            }
        }
        
        double average = sum / students.size();
        
        System.out.println("\n=== Grade Statistics ===");
        System.out.printf("Average grade: %.2f%n", average);
        System.out.printf("Highest grade: %.2f%n", highest);
        System.out.printf("Lowest grade: %.2f%n", lowest);
    }
}