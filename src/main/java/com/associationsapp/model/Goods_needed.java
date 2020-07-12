package com.associationsapp.model;

import javax.persistence.*;


@Entity
@Table(name = "Goods_needed")
public class Goods_needed {
    private long id ;
    private long amount ;
    private long event_id ;
    private long goods_id ;


    public Goods_needed(){}

    public Goods_needed (long id , long amount , long event_id , long goods_id){

        this.goods_id=goods_id ;
        this.event_id = event_id ;
        this.amount=amount ;
        this.id=id ;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}


    @Column (name ="amount" , nullable = false)
    public long getAmount(){return amount ;}
    public void setAmount(long amount){this.amount=amount;}

    @Column (name ="event_id" , nullable = false)
    public long getEvent_id(){return event_id ;}
    public void setEvent_id(long event_id){this.event_id=event_id;}

    @Column(name="goods_id" , nullable = false )
    public long getGoods_id(){return goods_id ;}
    public void setGoods_id(long goods_id){this.goods_id=goods_id ; }



}
