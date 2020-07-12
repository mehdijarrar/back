package com.associationsapp.controllers;



import com.associationsapp.model.Goods;
import com.associationsapp.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository ;

    @RequestMapping(value = "/Addgoods", method = RequestMethod.POST)
    public Goods createGoods(@RequestBody Goods goods){
        goodsRepository.save(goods);
        return goods ;
    }
    @RequestMapping(value = "/Modifygood", method = RequestMethod.POST)
    public Goods modifyGoods(@RequestBody Goods goods){
        goodsRepository.save(goods);
        return goods ;
    }
    
    @RequestMapping(value = "/Allgoods", method = RequestMethod.GET)
    public List<Goods> allGoods(){
        List<Goods> list = goodsRepository.findAll() ;
        return list ;
    }

    @RequestMapping(value = "/Removegoods" , method = RequestMethod.POST)
    public  void removeGoods(@RequestBody long a){

        goodsRepository.deleteById(a);


    }

}
