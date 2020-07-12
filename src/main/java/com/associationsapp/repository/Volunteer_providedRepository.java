package com.associationsapp.repository;
import com.associationsapp.model.Volunteer_provided ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface  Volunteer_providedRepository extends JpaRepository<Volunteer_provided,Long>{

    @Query("select v.volunteer_id from Volunteer_provided v where v.event_id = ?1")
    List<String> findByEvent_id(long id );

    @Query("select v.event_id from Volunteer_provided v where v.volunteer_id = ?1")
    List<Long> findByVolunteer_id(long id );

    @Modifying
    @Transactional
    @Query("delete from Volunteer_provided v where v.event_id = ?1")
    void deleteByEvent_id(Long id);
}
