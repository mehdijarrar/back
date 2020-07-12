package com.associationsapp.dto;
import lombok.Data;

@Data
public class UnconfirmedServiceDto {
    private long id ;
    private String name ;
    private long amount ;
    private String donor_email ;
    private String event_title ;

    public UnconfirmedServiceDto(long id ,String name, long amount,String donor_email , String event_title ){

        this.id=id ;
        this.name=name;
        this.amount=amount;
        this.donor_email=donor_email;
        this.event_title=event_title ;

    }
    public UnconfirmedServiceDto(){}

    public long getId() { return id; }
    public String getName() { return name; }
    public long getAmount() { return amount; }
    public String getDonor_email() { return donor_email; }
    public String getEvent_title() { return event_title; }
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAmount(long amount) { this.amount = amount; }
    public void setDonor_email(String donor_email) { this.donor_email = donor_email; }
    public void setEvent_title(String event_title) { this.event_title = event_title; }
}
