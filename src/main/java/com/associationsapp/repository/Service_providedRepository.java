package com.associationsapp.repository;
import com.associationsapp.model.Service_provided ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Service_providedRepository extends JpaRepository<Service_provided,Long>{

    @Query("select s.amount from Service_provided s where s.event_id = ?1 AND s.enabled=true ")
    List<Long> findAmountByEvent_id(Long id);

    @Query("select s from Service_provided s where s.enabled = ?1")
    List<Service_provided> findByEnabled(Boolean a) ;

    @Modifying
    @Transactional
    @Query("delete from Service_provided s where s.event_id = ?1")
    void deleteByEvent_id(Long id);
}
