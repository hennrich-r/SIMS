package SIMS;

import SIMS.Course;
import SIMS.Student;
import SIMS.CourseManager;

import java.util.Scanner;

public class Menu {

    public void displayMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("Please select an option:");
        System.out.println("1. Add a new student");
        System.out.println("2. select courses for a student");
        System.out.println("3. Search for a student");
        System.out.println("4. Update student information");
        System.out.println("5. Add a new course");
        System.out.println("6. View all courses");
        System.out.println("7. Update course information");
        System.out.println("8. Drop course for a student");
        System.out.println("9. set grades for a student");
        System.out.println("10. Exit");
        System.out.println("-----------------------------------------------");
    }

    public static void main(String[] args) {
        Student[] s = new Student[1000];
        Course[] c = new Course[1000];
        int currentCourseCount = 0;
        CourseManager cm = new CourseManager();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 10) {
            menu.displayMenu();
            System.out.print("Select option: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:// Add a new student
                    System.out.print("Enter name:");
                    String newName = scanner.nextLine();
                    System.out.print("Enter age:");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter gender:");
                    String newGender = scanner.nextLine();
                    System.out.print("Enter student ID:");
                    String newStudentID = scanner.nextLine();
                    System.out.print("Enter major:");
                    String newMajor = scanner.nextLine();
                    for(int i=0;i<s.length;i++)
                    {
                        if(s[i]==null)
                        {
                            s[i] = new Student(newName,newAge,newGender,newStudentID,newMajor);
                            break;
                        }
                    }
                    break;
                case 2:// select courses for a student
                    System.out.print("Enter student ID:");
                    String studentID = scanner.nextLine();
                    for(int i=0;i<s.length;i++)
                    {
                        if(s[i] != null && s[i].getStudentID().equals(studentID))
                        {
                            System.out.println("Enter CourseID:");
                            String selectingCourseID = scanner.nextLine();
                            for(int j=0;j<c.length;j++)
                            {
                                if(c[j] != null && c[j].getCourseID().equals(selectingCourseID))
                                {
                                    cm.selectCourse(s[i], c[j]);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 3:// Search for a student
                    System.out.print("Enter student ID:");
                    String searchingStudentID = scanner.nextLine();
                    boolean studentFound = false;
                    for(int i=0;i<s.length;i++)
                    {
                        if(s[i] != null && s[i].getStudentID().equals(searchingStudentID))
                        {
                            s[i].displayInfo();
                            studentFound = true;
                            break;
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:// Update student information
                    System.out.print("Enter student ID:");
                    String updatingStudentID = scanner.nextLine();
                    for(int i=0;i<s.length;i++)                    {
                        if(s[i] != null && s[i].getStudentID().equals(updatingStudentID))
                        {
                            System.out.println("Enter new name:");
                            String updatingName = scanner.nextLine();
                            System.out.println("Enter new age:");
                            int updatingAge = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter new gender:");
                            String updatingGender = scanner.nextLine();
                            System.out.println("Enter new student ID:");
                            String updatingStudentID1 = scanner.nextLine();
                            System.out.println("Enter new major:");
                            String updatingMajor = scanner.nextLine();
                            s[i].setName(updatingName);
                            s[i].setAge(updatingAge);
                            s[i].setGender(updatingGender);
                            s[i].setStudentID(updatingStudentID1);
                            s[i].setMajor(updatingMajor);
                            break;
                        }
                    }
                    break;
                case 5:// Add a new course
                    System.out.println("Enter course ID:");
                    String newCourseID = scanner.nextLine();
                    System.out.println("Enter course name:");
                    String newCourseName = scanner.nextLine();
                    System.out.println("Enter credits:");
                    int newCredits = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter max selected students:");
                    int newMaxSelectedStudents = Integer.parseInt(scanner.nextLine());
                    for(int i=0;i<c.length;i++)
                    {
                        if(c[i]==null)
                        {
                            c[i] = new Course(newCourseID,newCourseName,newCredits,newMaxSelectedStudents);
                            currentCourseCount++;
                            break;
                        }
                    }
                    break;
                case 6:// View all courses
                    System.out.println("All courses:");
                    for(int i=0;i<currentCourseCount;i++)
                    {
                        if(c[i] != null)
                        {
                            c[i].displayInfo();
                            System.out.println();
                        }
                        else
                        {
                            break;
                        }
                    }
                    break;
                case 7:// Update course information
                    System.out.print("Enter course ID:");
                    String updatingCourseID = scanner.nextLine();
                    boolean courseFound = false;
                    for(int i=0;i<currentCourseCount;i++)
                    {
                        if(c[i] != null && c[i].getCourseID().equals(updatingCourseID))
                        {
                            System.out.println("Enter new course name:");
                            String updatingCourseName = scanner.nextLine();
                            System.out.println("Enter new credits:");
                            int updatingCredits = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter new max selected students:");
                            int updatingMaxSelectedStudents = Integer.parseInt(scanner.nextLine());
                            c[i].setCourseName(updatingCourseName);
                            c[i].setCredits(updatingCredits);
                            c[i].setMaxSelectedStudents(updatingMaxSelectedStudents);
                            courseFound = true;
                            break;
                        }
                    }
                    if (!courseFound) {
                        System.out.println("Course not found.");
                    }
                    break;
                case 8:// Drop course for a student
                    System.out.print("Enter student ID:");
                    String droppingStudentID = scanner.nextLine();
                    boolean studentFoundForDrop = false;
                    for(int i=0;i<s.length;i++)
                    {
                        if(s[i] != null && s[i].getStudentID().equals(droppingStudentID))
                        {
                            studentFoundForDrop = true;
                            System.out.println("Enter course ID:");
                            String droppingCourseID = scanner.nextLine();
                            boolean courseFoundForDrop = false;
                            for(int j=0;j<c.length;j++)
                            {
                                if(c[j] != null && c[j].getCourseID().equals(droppingCourseID))
                                {
                                    courseFoundForDrop = true;
                                    cm.dropCourse(s[i], c[j]);
                                    break;
                                }
                            }
                            if (!courseFoundForDrop) {
                                System.out.println("Course not found.");
                            }
                            break;
                        }
                    }
                    if (!studentFoundForDrop) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 9:// Set grades for a student
                    System.out.print("Enter student ID:");
                    String gradingStudentID = scanner.nextLine();
                    boolean studentFoundForGrade = false;
                    for(int i=0;i<s.length;i++){
                        if(s[i] != null && s[i].getStudentID().equals(gradingStudentID))
                        {
                            studentFoundForGrade = true;
                            System.out.println("Enter course ID:");
                            String gradingCourseID = scanner.nextLine();
                            int enrolledIndex = s[i].findEnrolledCourseIndexByCourseID(gradingCourseID);
                            if (enrolledIndex != -1) {
                                System.out.println("Enter grades:");
                                int grades = Integer.parseInt(scanner.nextLine());
                                s[i].setEnrolledCoursesGrades(enrolledIndex, grades);
                            } else {
                                System.out.println("Student is not enrolled in this course.");
                            }
                            break;
                        }
                    }
                    if (!studentFoundForGrade) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 10:// Exit
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
