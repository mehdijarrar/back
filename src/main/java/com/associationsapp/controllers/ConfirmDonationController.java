package com.associationsapp.controllers;



import com.associationsapp.model.*;
import com.associationsapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.associationsapp.dto.UnconfirmedDonationDto ;
import com.associationsapp.dto.UnconfirmedServiceDto ;
import com.associationsapp.dto.UnconfirmedGoodsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConfirmDonationController {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private GoodsRepository goodsRepository ;
    @Autowired
    private ServiceRepository serviceRepository ;
    @Autowired
    private EventRepository eventRepository ;
    @Autowired
    private Service_providedRepository service_providedRepository ;
    @Autowired
    private Goods_providedRepository goods_providedRepository ;


    @RequestMapping(value = "/ConfirmDonation", method = RequestMethod.GET)
    public  UnconfirmedDonationDto show(){
        UnconfirmedDonationDto unconfirmedDonationDto = new UnconfirmedDonationDto();
    List<UnconfirmedGoodsDto> Listg = new ArrayList<UnconfirmedGoodsDto>() ;
    List<UnconfirmedServiceDto> Lists = new ArrayList<UnconfirmedServiceDto>() ;

    List<Service_provided> service_provideds = service_providedRepository.findByEnabled(false) ;
    List<Goods_provided> goods_provideds = goods_providedRepository.findByEnabled(false) ;
    for(Service_provided s:service_provideds){

        UnconfirmedServiceDto unconfirmedServiceDto = new UnconfirmedServiceDto() ;
           User user = userRepository.findById(s.getProvider_id()) .orElse(null) ;
            Service service = serviceRepository.findById(s.getService_id()).orElse(null) ;
        Event event =eventRepository.findById(s.getEvent_id()).orElse(null) ;
           unconfirmedServiceDto.setId(s.getId());
           unconfirmedServiceDto.setAmount(s.getAmount());
           unconfirmedServiceDto.setName(service.getDescription());
           unconfirmedServiceDto.setDonor_email(user.getEmail());
           unconfirmedServiceDto.setEvent_title(event.getTitle()) ;
           Lists.add(unconfirmedServiceDto) ;
    }
    for(Goods_provided g:goods_provideds){
        UnconfirmedGoodsDto unconfirmedGoodsDto = new UnconfirmedGoodsDto() ;
        User user = userRepository.findById(g.getProvider_id()) .orElse(null) ;
        Goods goods = goodsRepository.findById(g.getGoods_id()) .orElse(null) ;
        Event event =eventRepository.findById(g.getEvent_id()).orElse(null) ;
        unconfirmedGoodsDto.setId(g.getId());
        unconfirmedGoodsDto.setName(goods.getDescription());
        unconfirmedGoodsDto.setAmount(g.getAmount());
        unconfirmedGoodsDto.setDonor_email(user.getEmail());
        unconfirmedGoodsDto.setEvent_title(event.getTitle());
        Listg.add(unconfirmedGoodsDto) ;
    }
    unconfirmedDonationDto.setUnconfirmed_goods(Listg);
    unconfirmedDonationDto.setUnconfirmed_service(Lists);
    return unconfirmedDonationDto ;

    }

    @RequestMapping(value = "/Removeconfirmservice" , method = RequestMethod.POST)
    public  void removeconfirmService(@RequestBody long a){
        service_providedRepository.deleteById(a);
    }

    @RequestMapping(value = "/confirmservice" , method = RequestMethod.POST)
    public  void confirmService(@RequestBody long a){
        Service_provided service_provided = service_providedRepository.getOne(a) ;
        service_provided.setEnabled(true);
        service_providedRepository.save(service_provided) ;
    }

    @RequestMapping(value = "/Removeconfirmgoods" , method = RequestMethod.POST)
    public  void removeconfirmGoods(@RequestBody long a){
        goods_providedRepository.deleteById(a);
    }

    @RequestMapping(value = "/confirmgoods" , method = RequestMethod.POST)
    public  void confirmGoods(@RequestBody long a){
        Goods_provided goods_provided = goods_providedRepository.getOne(a) ;
        goods_provided.setEnabled(true);
        goods_providedRepository.save(goods_provided) ;
    }




}
