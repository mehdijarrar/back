package com.associationsapp.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "notif_token")
public class NotifToken {
    private long id ;
    private long user_id ;
    private String token ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){return id;}
    public void setId(long id){this.id = id;}


    @Column (name ="user_id" , nullable = false)
    public long getUser_id (){ return  user_id; }
    public void setUser_id(long user_id){this.user_id=user_id;}

    @Column(name="token" , nullable = false)
    public String getToken (){return token ; }
    public void setToken(String token) { this.token = token; }

    public NotifToken(){}
    public NotifToken( long id , long user_id , String token ){
        this.id = id ;
        this.token = token ;
        this.user_id = user_id ;

    }
}
