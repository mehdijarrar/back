package com.associationsapp.repository;

import com.associationsapp.model.Service_needed;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Service_neededRepository extends JpaRepository<Service_needed, Long> {
    @Query("select s from Service_needed s where s.event_id = ?1")
    List<Service_needed> findByEvent_id(Long id);
    @Query("select s.amount from Service_needed s where s.event_id = ?1")
    List<Long> findAmountByEvent_id(Long id);

    @Modifying
    @Transactional
    @Query("delete from Service_needed s where s.event_id = ?1")
    void deleteByEvent_id(Long id);

}
