package com.associationsapp.controllers;

import com.associationsapp.dto.CreateEventDto;
import com.associationsapp.model.Event;
import com.associationsapp.model.Goods_needed;
import com.associationsapp.model.Service_needed;
import com.associationsapp.model.Goods_provided ;
import com.associationsapp.model.Service_provided ;
import com.associationsapp.model.Volunteer_provided ;
import com.associationsapp.model.Money_provided ;

import com.associationsapp.dto.ListEventDto ;

import com.associationsapp.repository.EventRepository;
import com.associationsapp.repository.Goods_neededRepository;
import com.associationsapp.repository.Service_neededRepository;
import com.associationsapp.repository.Goods_providedRepository ;
import com.associationsapp.repository.Service_providedRepository ;
import com.associationsapp.repository.Volunteer_providedRepository ;
import com.associationsapp.repository.Money_providedRepository ;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController


public class EventsListController {

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
    private Money_providedRepository money_providedRepository  ;

    @RequestMapping(value ="/allevents" , method = RequestMethod.GET)
    public List<ListEventDto> allEvents(){
        List<ListEventDto> Liste = new ArrayList<ListEventDto>() ;

        List<Event>  events = eventRepository.findAll() ;
        for(Event e:events){
           ListEventDto dto = new ListEventDto();
           long ide = e.getId() ;
           dto.setId(ide);
            dto.setTitle(e.getTitle());
            dto.setMoney_needed((float) e.getMoney_needed());
            dto.setVolunteers_needed(e.getVolunteers_needed());

           long volunteers_needed = e.getVolunteers_needed() ;
           float money_needed = (float) e.getMoney_needed();
           List<String> volunteer_provideds  ;
           volunteer_provideds = volunteer_providedRepository.findByEvent_id(ide) ;
           dto.setVolunteers_provided(volunteer_provideds.size());

           List<Float> money_provided = money_providedRepository.findByEvent_id(ide) ;
           float totalmoney = 0 ;
            for (Float m : money_provided ) {
                totalmoney = totalmoney + m ;
            }

            dto.setMoney_provided(totalmoney) ;
            List<Long> service_needed = service_neededRepository.findAmountByEvent_id(ide) ;
            long totalservice_needed = 0 ;
            for(Long s : service_needed){
                totalservice_needed = totalservice_needed + s ;
            }
            dto.setService_needed(totalservice_needed);


            List<Long> service_provided = service_providedRepository.findAmountByEvent_id(ide) ;
            long totalservice_provided = 0 ;
            for(Long s : service_provided){
                totalservice_provided = totalservice_provided + s ;
            }
            dto.setService_provided(totalservice_provided);

            List<Long> goods_needed = goods_neededRepository.findAmountByEvent_id(ide) ;
            long totalgoods_needed = 0 ;
            for(Long g : goods_needed) {
                totalgoods_needed = totalgoods_needed + g ;
            }
            dto.setGoods_needed(totalgoods_needed);

            List<Long> goods_provided = goods_providedRepository.findAmountByEvent_id(ide) ;
            long totalgoods_provided = 0 ;
            for (Long g : goods_provided) {
                totalgoods_provided = totalgoods_provided + g ;
            }
            dto.setGoods_provided(totalgoods_provided);
           Liste.add(dto) ;
        }
    return Liste ;
    }

    @RequestMapping(value = "/Removeevent" , method = RequestMethod.POST)
    public  void removeEvent(@RequestBody long a){

       eventRepository.deleteById(a);
       goods_neededRepository.deleteByEvent_id(a) ;
       goods_providedRepository.deleteByEvent_id(a);
       money_providedRepository.deleteByEvent_id(a);
       service_neededRepository.deleteByEvent_id(a);
       service_providedRepository.deleteByEvent_id(a);
       volunteer_providedRepository.deleteByEvent_id(a);
    }
    @RequestMapping(value = "/Showevent/{a}" , method = RequestMethod.GET)
    public CreateEventDto modifyEvent(@PathVariable Long a){
        Event event = eventRepository.findByID(a) ;
        List<Service_needed> service_neededs = service_neededRepository.findByEvent_id(a) ;
        List<Goods_needed> goods_neededs = goods_neededRepository.findByEvent_id(a) ;

        CreateEventDto createEventDto = new CreateEventDto() ;
        createEventDto.setEvent(event);
        createEventDto.setGoods(goods_neededs);
        createEventDto.setService(service_neededs);
        return  createEventDto ;
    }

    @RequestMapping(value = "/modifyevent", method = RequestMethod.POST)
    public void modifyEvent(@RequestBody CreateEventDto createEventDto){

        Event myEvent =  eventRepository.save(createEventDto.getEvent()) ;
        List <Service_needed> services = createEventDto.getService();
        List <Goods_needed> goods = createEventDto.getGoods() ;

        for  ( Service_needed s:services){
            s.setEvent_id(myEvent.getId()); }
        for(Goods_needed g:goods){
            g.setEvent_id(myEvent.getId()); }
        service_neededRepository.deleteByEvent_id(myEvent.getId());
        goods_neededRepository.deleteByEvent_id(myEvent.getId());
        service_neededRepository.saveAll( services) ;
        goods_neededRepository.saveAll(goods) ;


    }




}
