package com.associationsapp.controllers;

import com.associationsapp.model.CourseRegistration;
import com.associationsapp.model.Goods_provided;
import com.associationsapp.repository.CourseRegistrationRepository;
import com.associationsapp.repository.CourseRepository;
import com.associationsapp.repository.EventRepository;
import com.associationsapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.associationsapp.model.Course ;
import com.associationsapp.model.Student ;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class TestController {
    @Autowired
    private CourseRepository courseRepository ;
    @Autowired
    private StudentRepository studentRepository ;
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository ;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List <Course> hello() {
       // Course course = new Course() ;
    //   course.setDescription("math") ;
      //  course =  courseRepository.save(course) ;

      //  Student student = new Student() ;
      //  student.setDescription("mehdi");
       // student = studentRepository.save(student) ;

      //  Long c = 666L ;
      //  Long s = 667L ;

     //   Student student = studentRepository.findById(s) .orElse(null) ;
    //    Course course = courseRepository.findById(c) . orElse(null) ;

   //     CourseRegistration courseRegistration = new CourseRegistration() ;
     //   courseRegistration.setStudent(student);
  //      courseRegistration.setCourse(course);
   //     int a = 15 ;
        //courseRegistration.setGrade(a);
      //  courseRegistrationRepository.deleteAll();
      //  courseRegistrationRepository.save(courseRegistration) ;

      //  Set<CourseRegistration> courseRegistrations = new HashSet<CourseRegistration>() ;
      //  CourseRegistration courseRegistration = new CourseRegistration() ;
      //  courseRegistration.setCourse(course);
      //  courseRegistration.setStudent(student);
      //  courseRegistrations.add(courseRegistration) ;

      //  course.setRegistrations(courseRegistrations);
      //  courseRepository.save(course) ;


        return courseRepository.findAll() ;
    }


    @RequestMapping(value = "/test1" , method = RequestMethod.POST)
    public  Course ss(@RequestBody Course course){

        //courseRegistrationRepository.saveAll( course.getRegistrationss()) ;
        courseRepository.save(course) ;
        return course ;
    }

    @RequestMapping(value = "/test2" , method = RequestMethod.POST)
    public  CourseRegistration ssa(@RequestBody CourseRegistration courseRegistration){
        courseRegistrationRepository.save(courseRegistration) ;
        return courseRegistration ;
    }
    @RequestMapping(value = "/test3" , method = RequestMethod.POST)
    public  Student ssz(@RequestBody Student student){
        studentRepository.save(student) ;
        return student ;
    }
}
