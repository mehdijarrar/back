package com.associationsapp.model;

import com.associationsapp.model.Course  ;
import com.associationsapp.model.CourseRegistration  ;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Set;



@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @Column (name ="description" , nullable = true)
    String description ;


    @OneToMany(mappedBy = "student")
    List<CourseRegistration> registrationsss;

    public Student(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<CourseRegistration> getRegistrationsss() {
        return registrationsss;
    }

    public void setRegistrationsss(List<CourseRegistration> registrationsss) {
        this.registrationsss = registrationsss;
    }

    public String getDescription(){return description ;}
    public void setDescription(String description){this.description=description;}

}
