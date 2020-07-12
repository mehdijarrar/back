package com.associationsapp.model;

import javax.persistence.*;


@Entity
@Table(name = "service_needed")
public class Service_needed {
    private long id ;
    private long amount ;
    private long event_id ;
    private long service_id ;

    public Service_needed(){}
    public Service_needed(long id , long amount , long event_id , long service_id){
        this.id =id ;
        this.amount = amount ;
        this.event_id = event_id ;
        this.service_id = service_id ;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}


    @Column (name ="amount" , nullable = false)
    public long getAmount(){return amount ;}
    public void setAmount(long amount){this.amount=amount;}

    @Column (name ="event_id" , nullable = false)
    public long getEvent_id(){return event_id ; }
    public void setEvent_id(long event_id){this.event_id = event_id ; }

    @Column (name ="service_id" , nullable = false)
    public long getService_id(){return service_id ;}
    public void setService_id(long service_id){this.service_id = service_id ; }




}
