package com.associationsapp.repository;
import com.associationsapp.model.NotifToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotifTokenRepository extends JpaRepository<NotifToken, Long > {
    @Query ("select n.token from NotifToken n where n.user_id = ?1")
    List<String> findByUser_id(Long id) ;

    @Query ("select n from NotifToken n where n.user_id = ?1 AND n.token= ?2")
    NotifToken findByUser_idAndToken(Long id , String token) ;
}
