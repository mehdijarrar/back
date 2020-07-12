package com.associationsapp.controllers;

import com.associationsapp.model.Service_needed ;
import com.associationsapp.repository.Service_neededRepository ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Sevice_neededController {
    @Autowired
    private Service_neededRepository service_neededRepository ;

    @RequestMapping(value ="/service_needed_by_event/{id}" , method = RequestMethod.GET )
    public List<Service_needed> Service_needed_by_event( @PathVariable Long id){

        return service_neededRepository.findByEvent_id(id) ;

    }



}
