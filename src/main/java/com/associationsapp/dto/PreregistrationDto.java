package com.associationsapp.dto;
import lombok.Data;

import java.util.List;


@Data
public class PreregistrationDto {
    private Long id ;
    private Long userid ;
    private String firstname ;
    private String lastname ;
    private String email ;
    private String event_title ;
    private List<String> tokens ;

    public PreregistrationDto(){
    }
    public PreregistrationDto(Long id, Long userid ,String firstname,String lastname,String email, String event_title ,List<String> tokens ){
        this.id = id ;
        this.userid = userid ;
        this.firstname = firstname ;
        this.lastname = lastname ;
        this.email = email ;
        this.event_title = event_title ;
        this.tokens  = tokens ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }
}
