package com.associationsapp.dto;
import com.associationsapp.model.Event;
import lombok.Data;


import java.util.List;


@Data
public class EventUserDto {

    private Event event ;
    private Boolean preregistrated ;
    public EventUserDto( Event event , Boolean preregistrated){
        this.event = event ;
        this.preregistrated = preregistrated ; }


    public EventUserDto(){}


    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public Boolean getPreregistrated() {
        return preregistrated;
    }

    public void setPreregistrated(Boolean preregistrated) {
        this.preregistrated = preregistrated;
    }
}
