package com.associationsapp.controllers;


import com.associationsapp.dto.EventUserDto;
import com.associationsapp.dto.PreregistrationDto;
import com.associationsapp.model.*;
import com.associationsapp.repository.*;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.stream.Collectors;

import com.associationsapp.payload.UploadFileResponse ;
import com.associationsapp.service.FileStorageService ;

import com.associationsapp.dto.CreateEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class EventController {
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private EventRepository eventRepository ;
    @Autowired
    private Service_neededRepository service_neededRepository ;
    @Autowired
    private Goods_neededRepository goods_neededRepository ;
    @Autowired
    private Goods_providedRepository goods_providedRepository ;
    @Autowired
    private Service_providedRepository service_providedRepository ;
    @Autowired
    private Volunteer_providedRepository volunteer_providedRepository ;
    @Autowired
    private Money_providedRepository money_providedRepository ;

    @Autowired
    private PreregistrationRepository preregistrationRepository ;

    @RequestMapping(value = "/create-event", method = RequestMethod.POST)
    public UploadFileResponse createEvent(@RequestParam("File") MultipartFile File , @RequestParam("createevent") String a  ){
        Gson w = new Gson();
        CreateEventDto createEventDto = w.fromJson(a,CreateEventDto.class) ;
        String fileName = fileStorageService.storeFile(File);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();


        Event myEvent =  eventRepository.save(createEventDto.getEvent()) ;
        myEvent.setUrl(fileDownloadUri);
        myEvent = eventRepository.save(myEvent) ;
        List <Service_needed> services = createEventDto.getService();
        List <Goods_needed> goods = createEventDto.getGoods() ;

        for  ( Service_needed s:services){
            s.setEvent_id(myEvent.getId()); }
        for(Goods_needed g:goods){
          g.setEvent_id(myEvent.getId()); }

        service_neededRepository.saveAll( services) ;
        goods_neededRepository.saveAll(goods) ;

        return new UploadFileResponse(fileName, fileDownloadUri,
                File.getContentType(), File.getSize());
    }


    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> events(){
        List<Event> list = eventRepository.findAll() ;
        return list ;
    }

    @RequestMapping(value = "/eventsuser/{id}", method = RequestMethod.GET)
    public List<EventUserDto> eventsuser(@PathVariable Long id){

        List<EventUserDto> Liste = new ArrayList<>() ;
        List<Event> list = eventRepository.findAll() ;
        for(Event e:list){
            EventUserDto dto = new EventUserDto() ;
            dto.setEvent(e);
            Preregistartion preregistartion = preregistrationRepository.findByEvent_idAndUser_id(e.getId(), id);
            if(preregistartion ==null){
                dto.setPreregistrated(false);
            }
            else{
                dto.setPreregistrated(true);
            }
            Liste.add(dto) ;

        }
        return Liste ;
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public CreateEventDto allGoods(@PathVariable Long id){
       Event event = eventRepository.findByID(id) ;
       List<Goods_needed> goods_neededs = goods_neededRepository.findByEvent_id(id) ;
       List<Service_needed> service_neededs = service_neededRepository.findByEvent_id(id) ;
       CreateEventDto createEventDto = new CreateEventDto();
       createEventDto.setEvent(event);
       createEventDto.setService(service_neededs);
       createEventDto.setGoods(goods_neededs);



        return createEventDto ;
    }
    @RequestMapping(value = "/donate_goods" , method = RequestMethod.POST)
    public  void donateGoods(@RequestBody Goods_provided goods_provided){

        goods_provided.setEnabled(false);

        goods_providedRepository.save(goods_provided) ;

    }

    @RequestMapping(value = "/donate_service" , method = RequestMethod.POST)
    public  void donateService(@RequestBody Service_provided service_provided){

        service_provided.setEnabled(false);
        service_providedRepository.save(service_provided) ;

    }

    @RequestMapping(value = "/participate_event" , method = RequestMethod.POST)
    public  void participate(@RequestBody Volunteer_provided volunteer_provided){

            volunteer_providedRepository.save(volunteer_provided) ;
            }

    @RequestMapping(value = "/donate_money" , method = RequestMethod.POST)
    public  void participate(@RequestBody Money_provided money_provided){

        money_providedRepository.save(money_provided) ;

    }



}
