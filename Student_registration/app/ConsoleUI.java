package assignment4.Student_registration.app;

import assignment4.Student_registration.domain.Course;
import assignment4.Student_registration.domain.Enrollment;
import assignment4.Student_registration.domain.Student;
import assignment4.Student_registration.exception.NotFoundException;
import assignment4.Student_registration.exception.ValidationException;
import assignment4.Student_registration.service.CourseService;
import assignment4.Student_registration.service.EnrollmentService;
import assignment4.Student_registration.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final Scanner scanner;

    public ConsoleUI(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n=== STUDENT REGISTRATION SYSTEM ===");
            System.out.println("1. Register New Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. View Courses");
            System.out.println("6. Enroll Student in Course (capacity + waitlist)");
            System.out.println("7. Drop Course (auto promote from waitlist)");
            System.out.println("8. Set Grade");
            System.out.println("9. Exit");
            System.out.print("Select: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        registerStudentUI();
                        break;
                    case "2":
                        updateStudentUI();
                        break;
                    case "3":
                        deleteStudentUI();
                        break;
                    case "4":
                        viewStudentsUI();
                        break;
                    case "5":
                        viewCoursesUI();
                        break;
                    case "6":
                        enrollUI();
                        break;
                    case "7":
                        dropUI();
                        break;
                    case "8":
                        setGradeUI();
                        break;
                    case "9":
                        return;
                    default:
                        System.out.println("Unknown option.");
                }
            } catch (ValidationException | NotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void registerStudentUI() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Faculty: ");
        String faculty = scanner.nextLine();

        studentService.registerStudent(id, name, email, faculty);
        System.out.println("OK: Student registered.");
    }

    private void updateStudentUI() {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New Email (leave blank to keep): ");
        String email = scanner.nextLine();

        System.out.print("New Faculty (leave blank to keep): ");
        String faculty = scanner.nextLine();

        studentService.updateStudent(id, email, faculty);
        System.out.println("OK: Student updated.");
    }

    private void deleteStudentUI() {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        // важно для capacity/waitlist - освобождаем места и продвигаем очередь
        enrollmentService.dropAllForStudent(id);

        studentService.deleteStudent(id);
        System.out.println("OK: Student deleted.");
    }

    private void viewStudentsUI() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
            for (Enrollment e : s.getEnrollments()) {
                System.out.println("   -> " + e);
            }
        }
    }

    private void viewCoursesUI() {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses.");
            return;
        }

        for (Course c : courses) {
            int active = enrollmentService.countActive(c.getCourseId());
            int wait = enrollmentService.countWaitlisted(c.getCourseId());
            int free = Math.max(0, c.getCapacity() - active);

            System.out.println(c);
            System.out.println("   Seats: " + active + "/" + c.getCapacity() + " | Free: " + free + " | Waitlist: " + wait);
        }
    }

    private void enrollUI() {
        System.out.print("Enter Student ID: ");
        int sId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Course ID: ");
        int cId = Integer.parseInt(scanner.nextLine());

        var status = enrollmentService.enroll(sId, cId);
        System.out.println("OK: Enrollment result = " + status);
    }

    private void dropUI() {
        System.out.print("Enter Student ID: ");
        int sId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Course ID: ");
        int cId = Integer.parseInt(scanner.nextLine());

        enrollmentService.drop(sId, cId);
        System.out.println("OK: Dropped. If there was a waitlist, someone may be promoted to ACTIVE.");
    }

    private void setGradeUI() {
        System.out.print("Enter Student ID: ");
        int sId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Course ID: ");
        int cId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Grade (0..100): ");
        double grade = Double.parseDouble(scanner.nextLine());

        enrollmentService.setGrade(sId, cId, grade);
        System.out.println("OK: Grade set.");
    }
}
