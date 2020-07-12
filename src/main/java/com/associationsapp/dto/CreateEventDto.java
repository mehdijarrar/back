package com.associationsapp.dto;


import com.associationsapp.model.Event;
import com.associationsapp.model.Goods_needed;
import com.associationsapp.model.Service_needed;
import lombok.Data;


import java.util.List;


@Data
public class CreateEventDto {

    private Event  event ;
    private List<Service_needed>  service  ;
    private List<Goods_needed> goods ;



    public CreateEventDto(Event event , List<Service_needed> service , List<Goods_needed> goods ){

        this.event = event ;
        this.service = service;
        this.goods = goods ;

    }
    public CreateEventDto(){
    }
    public Event getEvent(){ return event ; }
    public List<Service_needed> getService(){ return service ;  }
    public List<Goods_needed> getGoods(){return goods; }



    public void setEvent(Event event) { this.event = event; }
    public void setGoods(List<Goods_needed> goods) { this.goods = goods; }
    public void setService(List<Service_needed> service) { this.service = service; }

}
