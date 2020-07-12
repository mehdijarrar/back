package com.associationsapp.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "notification")
public class Notification {
    private long id ;
    private long sender_id ;
    private String receiver_id ;
    private String title ;
    private String body ;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
}
