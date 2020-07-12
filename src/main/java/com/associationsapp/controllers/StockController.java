package com.associationsapp.controllers;




import com.associationsapp.dto.ListEventDto;
import com.associationsapp.dto.StockGoodsDto;
import com.associationsapp.model.Goods;
import com.associationsapp.repository.GoodsRepository;


import com.associationsapp.model.Goods_provided;
import com.associationsapp.repository.Goods_providedRepository;

import com.associationsapp.model.Goods_needed;
import com.associationsapp.repository.Goods_neededRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController


public class StockController {


    @Autowired
    private GoodsRepository goodsRepository ;
    @Autowired
    private Goods_neededRepository goods_neededRepository ;
    @Autowired
    private Goods_providedRepository goods_providedRepository ;

    @RequestMapping(value = "/Stock", method = RequestMethod.GET)
    public List<StockGoodsDto> Stock(){
        List<StockGoodsDto> Liste = new ArrayList<StockGoodsDto>() ;
        List<Goods> goods = goodsRepository.findAll() ;
        for(Goods g:goods ){
            Long a , b ;

            StockGoodsDto dto = new StockGoodsDto() ;
            dto.setId(g.getId());
            dto.setDescription(g.getDescription());

            if(goods_providedRepository.findAmountByGoods_id(g.getId()) != null ){
                a =  goods_providedRepository.findAmountByGoods_id(g.getId()) ;

            }else {
                a=0l ;
            }
            if(goods_neededRepository.findAmountByGoods_id(g.getId()) != null){
                b =  goods_neededRepository.findAmountByGoods_id(g.getId()) ;
            } else{
                b = 0l ;
            }
            dto.setQuantity(a - b );
            Liste.add(dto) ;
        }

        return  Liste ;
    }


}
