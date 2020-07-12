package com.associationsapp.model;
import javax.persistence.*;

@Entity
@Table(name = "money_provided")
public class Money_provided {


    private long id ;
    private long provider_id ;
    private long event_id ;
    private float amount ;

    public Money_provided(){}

    public Money_provided( long id , long event_id , long provider_id , float amount){
        this.provider_id = provider_id ;
        this.event_id = event_id ;
        this.amount = amount ;
        this.id = id ;


    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    @Column (name ="provider_id" , nullable = false)
    public long getProvider_id(){return provider_id ;}
    public void setProvider_id(long provider_id){this.provider_id=provider_id;}

    @Column (name ="event_id" , nullable =  false)
    public long getEvent_id(){return event_id ; }
    public void setEvent_id(long event_id) { this.event_id = event_id;}

    @Column (name ="amount" , nullable = false)
    public float getAmount(){return amount ;}
    public void setAmount(float amount){this.amount=amount;}

}
