package com.associationsapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {



    private long id ;
    private String description ;

    public Service(){}
    public Service(long id , String description){
        this.id = id ;
        this.description = description ;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    @Column (name ="description" , nullable = false)
    public String getDescription(){return description ;}
    public void setDescription(String description){this.description=description;}


}
