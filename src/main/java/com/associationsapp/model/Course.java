package com.associationsapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column (name ="description" , nullable = true)
    String description ;


    @OneToMany(mappedBy = "course")
    List<CourseRegistration> registrationss;

    public Course(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public void setRegistrationss(List<CourseRegistration> registrationss) {
        this.registrationss = registrationss;
    }

    public List<CourseRegistration> getRegistrationss() {
        return registrationss;
    }

    public String getDescription(){return description ;}
    public void setDescription(String description){this.description=description;}

}
