package com.associationsapp.repository;

import com.associationsapp.model.Goods_provided ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Goods_providedRepository extends JpaRepository<Goods_provided,Long>{
    @Query("select g.amount from Goods_provided g where g.event_id = ?1 AND g.enabled=true" )
    List<Long> findAmountByEvent_id(Long id);
    @Query("select g from Goods_provided g where g.enabled = ?1")
    List<Goods_provided> findByEnabled(Boolean a) ;

    @Query("select SUM(g.amount) from Goods_provided g where g.goods_id = ?1 AND g.enabled=true ")
    Long findAmountByGoods_id(Long id);

    @Modifying
    @Transactional
    @Query("delete from Goods_provided g where g.event_id = ?1")
    void deleteByEvent_id(Long id);





}
