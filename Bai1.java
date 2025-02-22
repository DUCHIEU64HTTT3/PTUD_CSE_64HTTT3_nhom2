import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String className;
    private Map<String, Double> grades;

    public Student(String firstName, String lastName, String birthDate, String address, String className, Map<String, Double> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.className = className;
        this.grades = grades;
    }

    public double averageGrade() {
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        return total / grades.size();
    }

    public String gradeRank() {
        double avg = averageGrade();
        if (avg >= 8.5) {
            return "A";
        } else if (avg >= 7) {
            return "B";
        } else if (avg >= 5.5) {
            return "C";
        } else if (avg >= 4) {
            return "D";
        } else {
            return "<D";
        }
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", className='" + className + '\'' +
                ", grades=" + grades +
                '}';
    }
}

class ClassRoom {
    private String className;
    private List<Student> students;

    public ClassRoom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void summarizeByRank() {
        int countA = 0, countB = 0, countC = 0, countD = 0, countBelowD = 0;
        for (Student student : students) {
            String rank = student.gradeRank();
            switch (rank) {
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "C":
                    countC++;
                    break;
                case "D":
                    countD++;
                    break;
                default:
                    countBelowD++;
                    break;
            }
        }
        System.out.println("Summary of ranks for class " + className + ":");
        System.out.println("A: " + countA);
        System.out.println("B: " + countB);
        System.out.println("C: " + countC);
System.out.println("D: " + countD);
        System.out.println("<D: " + countBelowD);
    }

    public String getClassName() {
        return className;
    }
}

public class SchoolManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample data for students and classes
        ClassRoom class1 = new ClassRoom("Class 101");
        ClassRoom class2 = new ClassRoom("Class 102");

        Map<String, Double> grades1 = new HashMap<>();
        grades1.put("Lập trình hướng đối tượng", 8.0);
        grades1.put("Quản lý dự án", 7.5);
        grades1.put("Học Máy", 9.0);
        grades1.put("Cơ sở dữ liệu", 8.0);
        grades1.put("Lập trình ứng dụng cho TBDĐ", 7.0);
        Student student1 = new Student("Nguyen", "Van A", "2001-01-01", "Hanoi", "Class 101", grades1);

        Map<String, Double> grades2 = new HashMap<>();
        grades2.put("Lập trình hướng đối tượng", 6.0);
        grades2.put("Quản lý dự án", 6.5);
        grades2.put("Học Máy", 7.0);
        grades2.put("Cơ sở dữ liệu", 5.5);
        grades2.put("Lập trình ứng dụng cho TBDĐ", 6.0);
        Student student2 = new Student("Tran", "Thi B", "2002-02-02", "HCM", "Class 102", grades2);

        class1.addStudent(student1);
        class2.addStudent(student2);

        List<ClassRoom> classes = new ArrayList<>();
        classes.add(class1);
        classes.add(class2);

        // Display list of classes
        System.out.println("List of classes:");
        for (ClassRoom classroom : classes) {
            System.out.println(classroom.getClassName());
        }

        // Ask user to input a class to display students
        System.out.print("Enter class name to display students: ");
        String inputClassName = scanner.nextLine();

        for (ClassRoom classroom : classes) {
            if (classroom.getClassName().equalsIgnoreCase(inputClassName)) {
                classroom.displayStudents();
                classroom.summarizeByRank();
                break;
            }
        }
    }
}