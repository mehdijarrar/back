package com.associationsapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.associationsapp.model.Money_provided ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface Money_providedRepository extends JpaRepository<Money_provided,Long> {

    @Query("select v.amount from Money_provided v where v.event_id = ?1")
    List<Float> findByEvent_id(long id );
    @Modifying
    @Transactional
    @Query("delete from Money_provided m where m.event_id = ?1")
    void deleteByEvent_id(Long id);
}
