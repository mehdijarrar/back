package com.associationsapp.repository;


import com.associationsapp.model.Goods_needed;
import com.associationsapp.model.Service_needed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface Goods_neededRepository extends JpaRepository<Goods_needed, Long>  {

    @Query("select g.amount from Goods_needed g where g.event_id = ?1")
    List<Long> findAmountByEvent_id(Long id);

    @Query("select SUM(g.amount) from Goods_needed g where g.goods_id = ?1")
    Long findAmountByGoods_id(Long id);

    @Query("select g from Goods_needed g where g.event_id = ?1")
    List<Goods_needed> findByEvent_id(Long id);

    @Modifying
    @Transactional
    @Query("delete from Goods_needed g where g.event_id = ?1")
    void deleteByEvent_id(Long id);

}
