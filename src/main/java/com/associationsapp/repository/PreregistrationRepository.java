package com.associationsapp.repository;
import com.associationsapp.model.Preregistartion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
public interface PreregistrationRepository extends JpaRepository<Preregistartion,Long> {

    @Query("select p from Preregistartion p where p.event_id = ?1 and p.user_id =?2")
    Preregistartion findByEvent_idAndUser_id(long event_id , long user_id );
}
