package CODSOFT;

import java.util.*;

class Course {
    String code, title, description;
    int capacity;
    List<String> schedule;

    public Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = new ArrayList<>(schedule);
    }

    @Override
    public String toString() {
        return code + ": " + title + " (" + capacity + " slots available)" + "Schedule : " + schedule;
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.capacity > 0 && !registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.capacity--;
            System.out.println("Registered for " + course.title + " successfully.");
        } else {
            System.out.println("Cannot register " + course.title + ". No available slots or already registered.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.capacity++;
            System.out.println("Dropped " + course.title + " successfully.");
        } else {
            System.out.println("Not registered in " + course.title);
        }
    }
}

public class CourseRegistrationSystem {
    static List<Course> courses = new ArrayList<>();
    static Map<String, Student> students = new HashMap<>();
    static int studentIdCounter = 1; // Start ID counter

    private static void displayCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static Course findCourseByCode(String code) {
        for (Course course : courses) {
            if (course.code.equals(code)) {
                return course;
            }
        }
        return null;
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name to register: ");
        String name = scanner.nextLine();
        String id = "s" + studentIdCounter++;
        Student newStudent = new Student(id, name);
        students.put(id, newStudent);
        System.out.println("Student " + name + " added successfully with ID: " + id);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        courses.add(new Course("101", "Computer Science Engineering", "Fundamentals of Computer Science and Engineering", 50, Arrays.asList("Mon 10AM", "Wed 10AM")));
        courses.add(new Course("102", "Electronics Engineering", "Basics of Electronics Engineering", 50, Arrays.asList("Tue 11AM", "Thu 11AM")));
        courses.add(new Course("103", "Electrical Engineering", "Introduction to Electrical Engineering", 50, Arrays.asList("Mon 2PM", "Wed 2PM")));
        courses.add(new Course("104", "Civil Engineering", "Fundamentals of Civil Engineering", 50, Arrays.asList("Tue 9AM", "Thu 9AM")));
        courses.add(new Course("105", "Mechanical Engineering", "Introduction to Mechanical Engineering", 50, Arrays.asList("Mon 4PM", "Wed 4PM")));

        while (true) {
            System.out.println("\n1. List courses\n2. Register for a course\n3. Drop a course\n4. Add student\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayCourses();
                    break;
                case 2:
                    System.out.print("Enter your ID (If you are new, please register first using option 4): ");
                    String studentId = scanner.nextLine();
                    Student student = students.get(studentId);
                    if (student == null) {
                        System.out.println("Student ID not found. Please register as a new student.");
                        break;
                    }
                    System.out.print("Enter course code to register: ");
                    String courseCode = scanner.nextLine();
                    Course courseToRegister = findCourseByCode(courseCode);
                    if (courseToRegister != null) {
                        student.registerCourse(courseToRegister);
                    } else {
                        System.out.println("Invalid course code.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your ID: ");
                    studentId = scanner.nextLine();
                    student = students.get(studentId);
                    if (student == null) {
                        System.out.println("Invalid student ID.");
                        break;
                    }
                    System.out.print("Enter course code to drop: ");
                    String courseCodeToDrop = scanner.nextLine();
                    Course courseToDrop = findCourseByCode(courseCodeToDrop);
                    if (courseToDrop != null) {
                        student.dropCourse(courseToDrop);
                    } else {
                        System.out.println("Invalid course code.");
                    }
                    break;
                case 4:
                    addStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
