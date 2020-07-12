package com.associationsapp.controllers;

import com.associationsapp.dto.UserDto;
import com.associationsapp.model.Preregistartion ;
import com.associationsapp.model.Event ;
import com.associationsapp.model.User ;
import com.associationsapp.model.NotifToken ;
import com.associationsapp.dto.PreregistrationDto ;

import com.associationsapp.repository.UserRepository ;
import com.associationsapp.repository.EventRepository ;
import com.associationsapp.repository.PreregistrationRepository ;
import com.associationsapp.repository.NotifTokenRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PreregistartionController {
    @Autowired
    private PreregistrationRepository preregistrationRepository  ;
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private EventRepository eventRepository ;
    @Autowired
    private NotifTokenRepository notifTokenRepository ;
    @RequestMapping(value ="/preregistration" , method = RequestMethod.GET )
    public List<PreregistrationDto> Allpreregistation(){
       List<PreregistrationDto> Liste = new ArrayList<>() ;
       List<Preregistartion> preregistartions = preregistrationRepository.findAll() ;
       for(Preregistartion p:preregistartions){
           PreregistrationDto dto = new PreregistrationDto() ;
           User user = userRepository.findById(p.getUser_id()) .orElse(null) ;
           Event event = eventRepository.findById(p.getEvent_id()) .orElse(null) ;
            List<String> notifTokens = notifTokenRepository.findByUser_id(p.getUser_id()) ;
            dto.setId(p.getId());
            dto.setUserid(p.getUser_id());
            dto.setFirstname(user.getFirstname());
            dto.setLastname(user.getLastname());
            dto.setEmail(user.getEmail());
            dto.setEvent_title(event.getTitle());
            dto.setTokens(notifTokens);
            Liste.add(dto) ;
       }
       return Liste ;


    }

    @RequestMapping(value = "/Removepreregistration" , method = RequestMethod.POST)
    public  void removePre(@RequestBody long a){
        preregistrationRepository.deleteById(a);
    }

    @RequestMapping(value = "/addpreregistration" , method = RequestMethod.POST)
    public  void adddPre(@RequestBody Preregistartion preregistartion){
       preregistrationRepository.save(preregistartion) ;
    }
    @RequestMapping(value = "/deletepreregistration" , method = RequestMethod.POST)
    public  void deletePre(@RequestBody Preregistartion preregistartion){
        Preregistartion p = preregistrationRepository.findByEvent_idAndUser_id(preregistartion.getEvent_id() , preregistartion.getUser_id()) ;
        preregistrationRepository.deleteById(p.getId());
    }

}
