import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

// 1. Student class: only stores data
class Student {
    private String name;
    private List<Integer> marks;

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
    }
}

// 2. GradeCalculator: only calculates average & grade
class GradeCalculator {
    public double calculateAverage(List<Integer> marks) {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.size();
    }

    public String findGrade(double avg) {
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 50) return "C";
        return "F";
    }
}

// 3. StudentRepository: saves to console and file
class StudentRepository {
    public void save(Student student, double avg, String grade) {
        // Print to console
        System.out.println("------ Student Data ------");
        System.out.println("Name: " + student.getName());
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + grade);
        System.out.println("--------------------------");
        System.out.println("Student data saved successfully!");

        // Save to file
        try (FileWriter writer = new FileWriter("student.txt", true)) {
            writer.write("------ Student Data ------\n");
            writer.write("Name: " + student.getName() + "\n");
            writer.write("Average: " + avg + "\n");
            writer.write("Grade: " + grade + "\n");
            writer.write("--------------------------\n");
        } catch (IOException e) {
            System.out.println("Error saving student data to file: " + e.getMessage());
        }
    }
}

// 4. Main class
public class SRP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get student name
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        // Get number of subjects
        System.out.print("Enter number of subjects: ");
        int n = scanner.nextInt();

        // Get marks for each subject
        List<Integer> marks = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter mark for subject " + i + ": ");
            marks.add(scanner.nextInt());
        }

        // 1. Create student object
        Student student = new Student(name, marks);

        // 2. Calculate average and grade
        GradeCalculator calculator = new GradeCalculator();
        double average = calculator.calculateAverage(student.getMarks());
        String grade = calculator.findGrade(average);

        // 3. Save student data (print and file)
        StudentRepository repository = new StudentRepository();
        repository.save(student, average, grade);

        scanner.close();
    }
}
