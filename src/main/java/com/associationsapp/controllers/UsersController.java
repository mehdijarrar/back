package com.associationsapp.controllers;
import com.associationsapp.dto.CreateEventDto;
import com.associationsapp.dto.ListEventDto;
import com.associationsapp.model.Event;
import com.associationsapp.model.NotifToken;
import com.associationsapp.model.Service_needed;
import com.associationsapp.repository.NotifTokenRepository;
import com.associationsapp.repository.Service_neededRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.associationsapp.model.User ;
import com.associationsapp.repository.UserRepository ;
import com.associationsapp.dto.UserDto ;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private NotifTokenRepository notifTokenRepository ;

    @RequestMapping(value ="/users" , method = RequestMethod.GET )
    public List<UserDto> Allusers(){
        List<UserDto> Liste = new ArrayList<UserDto>() ;

        List<User>  users = userRepository.findAll() ;

        for(User user:users){
                UserDto dto = new UserDto() ;
                dto.setId(user.getId());
                dto.setFirstname(user.getFirstname());
                dto.setLastname(user.getLastname());
                dto.setEmail(user.getEmail());
                dto.setRole(user.getRole());
                Liste.add(dto) ;
        }
        return Liste ;
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserDto allGoods(@PathVariable Long id){
        User user = userRepository.getOne(id) ;
        UserDto dto = new UserDto() ;
        dto.setRole(user.getRole());
        dto.setEmail(user.getEmail());
        dto.setLastname(user.getLastname());
        dto.setFirstname(user.getFirstname());
        dto.setId(user.getId());
        return dto ;

    }

    @RequestMapping(value = "/Removeuser" , method = RequestMethod.POST)
    public  void removeUser(@RequestBody long a){

        userRepository.deleteById(a);
    }

    @RequestMapping(value = "/Addnotiftoken" , method = RequestMethod.POST)
    public  void AddToken(@RequestBody NotifToken notifToken){

        NotifToken n = notifTokenRepository.findByUser_idAndToken(notifToken.getUser_id() , notifToken.getToken()) ;
        if(n ==null){
            notifTokenRepository.save(notifToken) ;
        }
    }



}
