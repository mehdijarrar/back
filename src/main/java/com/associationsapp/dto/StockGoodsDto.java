package com.associationsapp.dto;
import lombok.Data;
@Data
public class StockGoodsDto {

   private long id  ;
   private String description ;
   private long quantity ;

   public StockGoodsDto(){}
   public StockGoodsDto( long id , String description , long quantity){
       this.id = id ;
       this.description = description ;
       this.quantity = quantity ;
   }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}
