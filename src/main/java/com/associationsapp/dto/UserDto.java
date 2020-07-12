package com.associationsapp.dto;
import lombok.Data;

@Data
public class UserDto {
    private long id ;
    private String firstname ;
    private String lastname ;
    private String email ;
    private String role ;

        public  UserDto(long id , String firstname , String lastname , String email , String role ){
            this.id = id ;
            this.firstname = firstname ;
            this.lastname = lastname ;
            this.email = email ;
            this.role = role ;

        }
        public UserDto(){}
    public void setId(long id) { this.id = id; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
}
