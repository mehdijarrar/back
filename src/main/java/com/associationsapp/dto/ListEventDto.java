package com.associationsapp.dto;
import lombok.Data;

import java.util.List;

@Data
public class ListEventDto {


    private long id ;
    private String title ;
    private long volunteers_needed ;
    private long volunteers_provided ;
    private float money_needed ;
    private float money_provided ;
    private long service_needed ;
    private long service_provided ;
    private long goods_needed ;
    private long goods_provided ;




    public ListEventDto(long id , String title , long volunteers_needed , long volunteers_provided , float money_needed , float money_provided,
                         long service_needed , long service_provided , long goods_needed , long goods_provided ){
        this.id = id ;
        this.title = title ;
        this.volunteers_needed = volunteers_needed ;
        this.volunteers_provided = volunteers_provided ;
        this.money_needed = money_needed ;
        this.money_provided = money_provided ;
        this.service_needed = service_needed ;
        this.service_provided = service_provided ;
        this.goods_needed = goods_needed ;
        this.goods_provided = goods_provided ;


    }
    public ListEventDto() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public long getVolunteers_needed() { return volunteers_needed; }
    public void setVolunteers_needed(long volunteers_needed) { this.volunteers_needed = volunteers_needed; }

    public long getVolunteers_provided() { return volunteers_provided; }
    public void setVolunteers_provided(long volunteers_provided) { this.volunteers_provided = volunteers_provided; }

    public float getMoney_needed() { return money_needed; }
    public void setMoney_needed(float money_needed) { this.money_needed = money_needed; }

    public float getMoney_provided() { return money_provided; }
    public void setMoney_provided(float money_provided) { this.money_provided = money_provided; }

    public long getService_needed() { return service_needed; }
    public void setService_needed(long service_needed) { this.service_needed = service_needed; }

    public long getService_provided() { return service_provided; }
    public void setService_provided(long service_provided) { this.service_provided = service_provided; }

    public long getGoods_needed() { return goods_needed; }
    public void setGoods_needed(long goods_needed) { this.goods_needed = goods_needed; }

    public long getGoods_provided() { return goods_provided; }
    public void setGoods_provided(long goods_provided) { this.goods_provided = goods_provided; }
}
