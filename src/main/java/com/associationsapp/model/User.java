package com.associationsapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User {
    private long id ;
    private String email ;
    private String password ;
    private String firstname ;
    private String lastname;
    private String role;
    private Boolean enable ;
    private String confirmation ;

    public  User (String email , String password , String firstname , String lastname , String role,Boolean enable,String confirmation){

        this.email=email ;
        this.password=password ;
        this.firstname=firstname ;
        this.lastname = lastname ;
        this.role = role ;
        this.enable = enable ;
        this.confirmation = confirmation ;

    }
    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    @Column (name ="email" , nullable = false)
    public String getEmail(){return email ;}
    public void setEmail(String email){this.email=email;}

    @Column(name = "password", nullable = true)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "firstname", nullable = true)
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    @Column(name = "lastname", nullable = true)
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    @Column(name = "role", nullable = true)
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "enable", nullable = true)
    public Boolean getEnable() { return enable; }
    public void setEnable(Boolean enable) { this.enable = enable; }

    @Column(name = "confirmation", nullable = true)
    public String getConfirmation(){return confirmation ; }

    public void setConfirmation(String confirmation) { this.confirmation = confirmation; }
}
