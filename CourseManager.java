package SIMS;

import SIMS.Course;

public class CourseManager {

    public CourseManager() {
    }

    public void addCourse(String courseID, String courseName, int credits, int MaxSelectedStudents) {
        Course newCourse = new Course(courseID, courseName, credits, MaxSelectedStudents);
    }

    public void selectCourse(Student student, Course course) {
        if (student == null || course == null) return;
        if (student.findEnrolledCourseIndex(course.getCourseID()) != -1) {
            System.out.println("Student has already enrolled in this course.");
            return;
        }
        if (course.getCurrentSelectedStudents() >= course.getMaxSelectedStudents()) {
            System.out.println("Course is full.");
            return;
        }
        boolean added = student.addCourse(course);
        if (added) {
            course.setCurrentSelectedStudents(course.getCurrentSelectedStudents() + 1);
            System.out.println("Course selected successfully.");
        } else {
            System.out.println("Failed to select course.");
        }
    }

    public void dropCourse(Student student, Course course) {
        if (student == null || course == null) return;
        boolean removed = student.removeCourse(course);
        if (removed) {
            int newCount = course.getCurrentSelectedStudents() - 1;
            if (newCount < 0) {
                newCount = 0;
            }
            course.setCurrentSelectedStudents(newCount);
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }
}
