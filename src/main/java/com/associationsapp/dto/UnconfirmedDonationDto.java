package com.associationsapp.dto;
import com.associationsapp.dto.UnconfirmedServiceDto ;
import com.associationsapp.dto.UnconfirmedGoodsDto ;


import lombok.Data;

import java.util.List;


@Data
public class UnconfirmedDonationDto {
    private List <UnconfirmedGoodsDto> unconfirmed_goods ;
    private List <UnconfirmedServiceDto> unconfirmed_service ;

    public UnconfirmedDonationDto(List <UnconfirmedGoodsDto> unconfirmed_goods,List <UnconfirmedServiceDto> unconfirmed_service ){
        this.unconfirmed_goods = unconfirmed_goods ;
        this.unconfirmed_service = unconfirmed_service ;
    }
    public UnconfirmedDonationDto(){}

    public List<UnconfirmedGoodsDto> getUnconfirmed_goods() {
        return unconfirmed_goods;
    }

    public List<UnconfirmedServiceDto> getUnconfirmed_service() {
        return unconfirmed_service;
    }

    public void setUnconfirmed_goods(List<UnconfirmedGoodsDto> unconfirmed_goods) {
        this.unconfirmed_goods = unconfirmed_goods;
    }

    public void setUnconfirmed_service(List<UnconfirmedServiceDto> unconfirmed_service) {
        this.unconfirmed_service = unconfirmed_service;
    }
}
