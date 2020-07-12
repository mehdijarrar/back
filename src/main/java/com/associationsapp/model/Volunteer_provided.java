package com.associationsapp.model;
import javax.persistence.*;


@Entity
@Table(name = "volunteer_provided")
public class Volunteer_provided {
    private long id ;
    private long volunteer_id ;
    private long event_id ;

    public Volunteer_provided(){}
    public Volunteer_provided(long id , long volunteer_id , long event_id){
        this.id = id ;
        this.volunteer_id = volunteer_id ;
        this.event_id = event_id ;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    @Column (name ="volunteer_id" , nullable = false)
    public long getVolunteer_id(){return volunteer_id ;}
    public void setVolunteer_id(long volunteer_id){this.volunteer_id = volunteer_id ; }

    @Column (name ="event_id" , nullable = false)
    public long getEvent_id(){return event_id ; }
    public void  setEvent_id(long event_id){this.event_id = event_id ; }

}
