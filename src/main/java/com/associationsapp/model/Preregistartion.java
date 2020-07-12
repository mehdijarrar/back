package com.associationsapp.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "preregistration")
public class Preregistartion {

    private long id ;
    private long user_id ;
    private long event_id ;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    @Column (name ="user_id" , nullable = false)
    public long getUser_id (){ return  user_id; }
    public void setUser_id(long user_id){this.user_id=user_id;}

    @Column (name ="event_id" , nullable = false)
    public long getEvent_id (){ return  event_id ;}
    public void setEvent_id(long event_id){this.event_id=event_id;}
    public Preregistartion(){}
    public Preregistartion(long id , long user_id , long event_id){
        this.id = id ;
        this.user_id = user_id ;
        this.event_id = event_id ;
    }
}
