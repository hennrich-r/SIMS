package SIMS;

public class Course {
    
    private String courseID;
    private String courseName;
    private int credits;
    private int MaxSelectedStudents;
    private int currentSelectedStudents;
    private int grades;

    public Course(String courseID, String courseName, int credits, int MaxSelectedStudents) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.MaxSelectedStudents = MaxSelectedStudents;
        this.currentSelectedStudents = 0;
        this.grades = 0;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getMaxSelectedStudents() {
        return MaxSelectedStudents;
    }

    public int getCurrentSelectedStudents() {
        return currentSelectedStudents;
    }
    public int getGrades() {
        return grades;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setMaxSelectedStudents(int MaxSelectedStudents) {
        this.MaxSelectedStudents = MaxSelectedStudents;
    }

    public void setCurrentSelectedStudents(int currentSelectedStudents) {
        this.currentSelectedStudents = currentSelectedStudents;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public void displayInfo() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
        System.out.println("Credits: " + credits);
        System.out.println("Max Selected Students: " + MaxSelectedStudents);
        System.out.println("Current Selected Students: " + currentSelectedStudents);
    }
}
