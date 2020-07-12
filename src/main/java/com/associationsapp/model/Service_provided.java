package com.associationsapp.model;

import javax.persistence.*;


@Entity
@Table(name = "service_provided")
public class Service_provided {


    private long id ;
    private long provider_id ;
    private long amount ;
    private long event_id ;
    private long service_id ;
    private  boolean enabled  ;

    public Service_provided(){}

    public Service_provided(long id,long provider_id ,long amount , long event_id , long service_id , boolean enabled ){
        this.id = id ;
        this.provider_id = provider_id ;
        this.amount = amount ;
        this.event_id = event_id ;
        this.service_id = service_id ;
        this.enabled = enabled ;


    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    @Column (name ="provider_id" , nullable = false)
    public long getProvider_id(){return provider_id ;}
    public void setProvider_id(long provider_id){this.provider_id = provider_id ; }

    @Column (name ="amount" , nullable = false)
    public long getAmount(){return amount ;}
    public void setAmount(long amount){this.amount=amount;}

    @Column (name ="event_id" , nullable = false)
    public long getEvent_id(){return event_id ; }
    public void setEvent_id(long event_id){this.event_id = event_id ; }

    @Column (name ="service_id" , nullable = false)
    public long getService_id(){return service_id ;}
    public void setService_id(long service_id){this.service_id = service_id ; }

    @Column (name ="enable" , nullable = false)
    public boolean getEnabled(){ return enabled ; }
    public void setEnabled(boolean enabled){this.enabled = enabled; }




}
