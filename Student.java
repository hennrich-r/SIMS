package SIMS;

import SIMS.Person;
import SIMS.Course;

public class Student extends Person {
    
    private String studentID;
    private String major;
    Course[] enrolledCourses;
    private int currentEnrolledCoursesCount;
    
    
    public Student(String name, int age, String gender, String studentID, String major) {
        super(name, age, gender);
        this.studentID = studentID;
        this.major = major;
        this.enrolledCourses = new Course[10];
        this.currentEnrolledCoursesCount = 0;
    }

    public boolean addEnrolledCourse(Course course) {
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] == null) {
                enrolledCourses[i] = course;
                currentEnrolledCoursesCount++;
                return true;
            }
            if (enrolledCourses[i] != null && enrolledCourses[i].getCourseID().equals(course.getCourseID())) {
                return false;
            }
        }
        return false;
    }

    public boolean removeEnrolledCourse(String courseID) {
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] != null && enrolledCourses[i].getCourseID().equals(courseID)) {
                enrolledCourses[i] = null;
                currentEnrolledCoursesCount--;
                return true;
            }
        }
        return false;
    }

    public int findEnrolledCourseIndexByCourseID(String courseID) {
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] != null && enrolledCourses[i].getCourseID().equals(courseID)) {
                return i;
            }
        }
        return -1;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setEnrolledCoursesGrades(int index, int grades) {
        if (index >= 0 && index < enrolledCourses.length && enrolledCourses[index] != null) {
            enrolledCourses[index].setGrades(grades);
        }
    }

    public int getEnrolledCoursesGrades(int index) {
        if (index >= 0 && index < enrolledCourses.length && enrolledCourses[index] != null) {
            return enrolledCourses[index].getGrades();
        }
        return -1;
    }

    public int findEnrolledCourseIndex(String courseID) {
        for (int i = 0; i < currentEnrolledCoursesCount; i++) {
            if (enrolledCourses[i] != null && enrolledCourses[i].getCourseID().equals(courseID)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addCourse(Course course) {
        if (course == null) return false;
        if (findEnrolledCourseIndex(course.getCourseID()) != -1) return false;
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] == null) {
                enrolledCourses[i] = course;
                currentEnrolledCoursesCount++;
                return true;
            }
        }
        return false;
    }

    public boolean removeCourse(Course course) {
        if (course == null) return false;
        for (int i = 0; i < currentEnrolledCoursesCount; i++) {
            if (enrolledCourses[i] != null && enrolledCourses[i].getCourseID().equals(course.getCourseID())) {
                for (int j = i; j < currentEnrolledCoursesCount - 1; j++) {
                    enrolledCourses[j] = enrolledCourses[j + 1];
                }
                enrolledCourses[currentEnrolledCoursesCount - 1] = null;
                currentEnrolledCoursesCount--;
                return true;
            }
        }
        return false;
    }

    public int calculateTotalCredits() {
        int totalCredits = 0;
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] != null) {
                totalCredits += enrolledCourses[i].getCredits();
            }
        }
        return totalCredits;
    }

    public int calculateGrades() {
        int totalGrades = 0;
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] != null) {
                totalGrades += enrolledCourses[i].getGrades();
            }
        }
        return totalGrades;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentID);
        System.out.println("Major: " + major);
        System.out.println("Enrolled Courses:");
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] != null) {
                System.out.println("- " + enrolledCourses[i].getCourseName()+"---"+enrolledCourses[i].getGrades());
            }
        }
        System.out.println("Total Credits: " + calculateTotalCredits());
        System.out.println("Total Grades: " + calculateGrades());
    }
}
