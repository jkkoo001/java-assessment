package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();


    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }


    public Student findStudent( String studentId )
    {
        if (students.containsKey(studentId)) {
            return students.get(studentId);
        }
        return null;
    }


    public boolean showSummary()
    {
        return (students.size() != 0);
    }


    public void enrollToCourse( String studentId, Course course )
    {
        Student student = this.students.get(studentId);
        student.enrollToCourse(course);
    }


    @Override
    public String toString() {

        String printStudentInfo;
        String printCourse = "";
        String printSummary = "";
        for (Student value : students.values()) {
            List<Course> courses = value.getEnrolledCourses();
            for (int i = 0; i < courses.size(); i++) {
                String courseId = courses.get(i).getCode();
                Map<String, Double> courseGrade = value.getCourseGrade();
                if (courseGrade.containsKey(courseId)) {
                    printCourse = printCourse + courses.get(i) + " Grade: " + courseGrade.get(courseId) + "\n";
                }
                else {

                    printCourse = printCourse + courses.get(i) + "\n";
                }
            }
            if (courses.size() == 0) {
                printStudentInfo = value + "\n";
            }
            else {
                printStudentInfo = value + "\nEnrolled Courses: \n" + printCourse + "\n";
            }
            printSummary += printStudentInfo;
            printCourse = "";

        }
        return printSummary;
    }

}   //End of Class
