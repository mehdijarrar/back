package com.associationsapp.model;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {

    private long id ;
    private long userid ;
    private String title ;
    private String description ;
    private String place;
    private String date;
    private long volunteers_needed ;
    private double money_needed ;
    private String url ;


    public Event(){}

    public  Event(long userid , String title , String place , String date , long volunteers_needed ,double money_needed , String url , String description  ){
        this.description = description ;
        this.userid=userid ;
        this.title=title ;
        this.place=place ;
        this.date = date ;
        this.volunteers_needed = volunteers_needed ;
        this.money_needed = money_needed ;
        this.url = url ;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    @Column (name ="userid" , nullable = false)
    public long getUserid(){return userid ;}
    public void setUserid(long userid){this.userid = userid;}

    @Column (name ="title" , nullable = false)
    public String getTitle(){return title ;}
    public void setTitle(String title){this.title=title;}
    @Column (name ="description" , nullable = false , columnDefinition = "LONGTEXT")
    public String getDescription(){return description ;}
    public void setDescription(String description){this.description=description;}
    @Column (name ="place" , nullable = false)
    public String getPlace(){return place ;}
    public void setPlace(String place){this.place=place;}

    @Column (name ="date" , nullable = false)
    public String getDate(){return date ;}
    public void setDate(String date){this.date=date;}

    @Column (name = "volunteers_needed" , nullable = true)
    public long getVolunteers_needed(){ return  volunteers_needed ; }
    public void setVolunteers_needed(long volunteers_needed){ this.volunteers_needed=volunteers_needed;}

    @Column(name ="money_needed" , nullable = true)
    public double getMoney_needed(){return money_needed ; }
    public void setMoney_needed(double money_needed){ this.money_needed=money_needed ; }
    @Column(name="url" , nullable=true)
    public String getUrl(){return url ; }

    public void setUrl(String url) { this.url = url; }
}
