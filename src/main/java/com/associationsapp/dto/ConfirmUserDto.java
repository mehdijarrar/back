package com.associationsapp.dto;
import lombok.Data;


import java.util.List;


@Data
public class ConfirmUserDto {
    private String email ;
    private String confirmation ;

    ConfirmUserDto(String email , String confirmation){
        this.email = email ;
        this.confirmation = confirmation ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
}
