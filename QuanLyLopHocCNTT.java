import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String address;
    private String className;
    private double oop, projectManagement, machineLearning, database, mobileDev;

    public Student(String firstName, String lastName, String birthdate, String address, String className,
                   double oop, double projectManagement, double machineLearning, double database, double mobileDev) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.oop = oop;
        this.projectManagement = projectManagement;
        this.machineLearning = machineLearning;
        this.database = database;
        this.mobileDev = mobileDev;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getAverageScore() {
        return (oop + projectManagement + machineLearning + database + mobileDev) / 5;
    }

    public String getRank() {
        double avg = getAverageScore();
        if (avg >= 8.5) return "A";
        else if (avg >= 7.0) return "B";
        else if (avg >= 5.5) return "C";
        else if (avg >= 4.0) return "D";
        else return "<D";
    }
}

class Classroom {
    private String classId;
    private List<Student> students;

    public Classroom(String classId) {
        this.classId = classId;
        this.students = new ArrayList<>();
    }

    public String getClassId() {
        return classId;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("\nDANH SACH SINH VIEN LOP " + classId);
        for (Student student : students) {
            System.out.println(student.getFullName() + " - DiemTB: " + student.getAverageScore() + " - Xep loai: " + student.getRank());
        }
    }

    public void rankSummary() {
        Map<String, Integer> rankCount = new HashMap<>();
        rankCount.put("A", 0);
        rankCount.put("B", 0);
        rankCount.put("C", 0);
        rankCount.put("D", 0);
        rankCount.put("<D", 0);

        for (Student student : students) {
            String rank = student.getRank();
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        System.out.println("\nTHONG KE XEP LOAI LOP " + classId);
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " sinh vien");
        }
    }
}

public class QuanLyLopHocCNTT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Classroom> classMap = new HashMap<>();

        Classroom class1 = new Classroom("64HTTT3");
        class1.addStudent(new Student("Bui", "Nam", "1994-08-03", "DakLak", "64HTTT3", 9, 8, 7.5, 8, 9));
        class1.addStudent(new Student("Nguyen", "Thach", "1990-12-10", "HCM", "64HTTT3", 8, 7, 9, 10, 7));
        class1.addStudent(new Student("Tran", "Khoa", "1994-05-06", "HCM", "64HTTT3", 10, 5.5, 9, 8, 7));
        classMap.put("64HTTT3", class1);

        Classroom class2 = new Classroom("64HTTT4");
        class2.addStudent(new Student("Pham", "Thuan", "1989-07-24", "HCM", "64HTTT4", 9, 8, 9, 8, 7));
        class2.addStudent(new Student("Tran", "Bao", "1990-08-20", "An Giang", "64HTTT4", 8, 5.5, 6, 8, 7));
        class2.addStudent(new Student("Nguyen", "Son", "1992-09-10", "Ha Noi", "64HTTT4", 10, 9, 6, 8, 7));
        classMap.put("64HTTT4", class2);

        System.out.println("\nDanh sach cac lop:");
        for (Classroom classroom : classMap.values()) {
            System.out.println(classroom.getClassId());
        }

        System.out.print("\nNhap ma lop de xem chi tiet: ");
        String input = scanner.nextLine();

        Classroom selectedClass = classMap.get(input);
        if (selectedClass != null) {
            selectedClass.displayStudents();
            selectedClass.rankSummary();
        } else {
            System.out.println("Khong tim thay lop nay!");
        }

        scanner.close();
    }
}
