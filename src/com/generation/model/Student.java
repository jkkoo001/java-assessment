package com.generation.model;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{

    float PASS_MIN_GRADE = 3.0f;


    private List<Course> enrolledCourses;
    private Map<String, Double> courseGrade = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );

        this.enrolledCourses = new ArrayList<>();
    }


    public void enrollToCourse( Course course )
    {
        this.enrolledCourses.add(course);
    }


    @Override
    public List<Course> findPassedCourses()
    {
        List<Course> course = this.getEnrolledCourses();
        List<Course> passedCourse = new ArrayList<>();
        Map<String, Double> courseGrade = this.getCourseGrade();
        for (Course c: course) {
            if (courseGrade.containsKey(c.getCode()) && courseGrade.get(c.getCode())>= PASS_MIN_GRADE) {
                passedCourse.add(c);
            }
        }
        return passedCourse;
    }


    public Course findCourseById( String courseId )
    {
        List<Course> course = this.getEnrolledCourses();
        for (Course c: course) {
            if (c.getCode().equals(courseId)) {
                return c;
            }
        }
        return null;
    }


    public void setGrade(String courseId, double grade) {
        if (grade < 1 || grade > 6) {
            System.out.println("Invalid Grade. Please enter grade between 1 to 6.");
        }
        else {
            Map<String, Double> courseGrade = this.courseGrade;
            courseGrade.put(courseId, grade);
        }
    }


    public Map<String, Double> getCourseGrade()
    {
        return this.courseGrade;
    }


    @Override
    public List<Course> getEnrolledCourses()
    {
        return this.enrolledCourses;
    }


    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }


}   //End of Class
