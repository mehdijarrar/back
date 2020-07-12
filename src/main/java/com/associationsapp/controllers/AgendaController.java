package com.associationsapp.controllers;




import com.associationsapp.dto.AgendaDto;
import com.associationsapp.model.Goods;
import com.associationsapp.repository.Volunteer_providedRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.associationsapp.model.Event;
import com.associationsapp.repository.EventRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AgendaController {

    @Autowired
    private EventRepository eventRepository ;
    @Autowired
    private Volunteer_providedRepository volunteer_providedRepository ;

    @RequestMapping(value = "/Myagenda/{a}", method = RequestMethod.GET)
    public List<AgendaDto> createGoods(@PathVariable Long a){
        System.out.println(a);
        List<AgendaDto> AgList = new ArrayList<>() ;
        List<Long> liste = volunteer_providedRepository.findByVolunteer_id(a) ;
        for(Long l : liste){

            Event event = eventRepository.findById(l) .orElse(null) ;
            if(event != null){

                AgendaDto dto = new AgendaDto() ;
                dto.setDate(event.getDate());
                dto.setTitle(event.getTitle());
                AgList.add(dto);
            }

        }

        return AgList ;


    }
}
