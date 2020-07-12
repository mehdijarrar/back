package com.associationsapp.dto;
import lombok.Data;


import java.util.List;


@Data
public class AgendaDto {

    private String title ;
    private String date ;

    public  AgendaDto(){}

    public  AgendaDto(String title,String date){
        this.date=date ;
        this.title = title ;

    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
