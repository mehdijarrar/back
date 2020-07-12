package com.associationsapp.controllers;


import com.associationsapp.model.Service ;
import com.associationsapp.repository.ServiceRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository ;

    @RequestMapping(value = "/Addservice", method = RequestMethod.POST)
    public Service createService(@RequestBody Service service){
        serviceRepository.save(service);
        return service ;
    }
    @RequestMapping(value = "/Modifyservice", method = RequestMethod.POST)
    public Service modifyService(@RequestBody Service service){
        serviceRepository.save(service);
        return service ;
    }

    @RequestMapping(value = "/Allservice", method = RequestMethod.GET)
    public List<Service> allservice(){
        List<Service> list = serviceRepository.findAll() ;
        return list ;
    }


    @RequestMapping(value = "/Removeservice" , method = RequestMethod.POST)
    public  void removeService(@RequestBody long a){
        serviceRepository.deleteById(a);
    }



}
