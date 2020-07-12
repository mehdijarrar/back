package com.associationsapp.model;

import javax.persistence.*;


@Entity
@Table(name = "Goods_provided")
public class Goods_provided {


    private long id ;
    private long provider_id ;
    private long amount ;
    private long event_id ;
    private long goods_id ;
    private boolean enabled ;

    public Goods_provided(){}
    public Goods_provided( long id , long provider_id , long amount , long event_id , long goods_id , boolean enabled){
        this.amount = amount ;
        this.enabled = enabled ;
        this.event_id = event_id ;
        this.goods_id = goods_id ;
        this.provider_id = provider_id ;
        this.id = id ;

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

    @Column(name ="event_id" , nullable = false)
    public long getEvent_id(){return event_id ;}
    public void setEvent_id(long event_id) { this.event_id = event_id; }

    @Column (name ="goods_id" , nullable = false)
    public long getGoods_id(){return goods_id ;}
    public void setGoods_id(long goods_id){this.goods_id = goods_id ; }

    @Column (name ="enabled" , nullable = false)
    public boolean getEnabled() { return enabled ; }
    public void setEnabled(boolean enabled){this.enabled = enabled; }


}
