package com.associationsapp.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class CourseRegistration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;


    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;


    @Column (name ="grade" , nullable = true)
    int grade ;


   public CourseRegistration(){}

   public CourseRegistration( Course course ,  Student student , int grade){
       this.course=course ;

       this.student=student ;

       this.grade = grade ;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}
