package com.associationsapp.repository;

import com.associationsapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u.email from User u where u.email = ?1")
    String findByEmail(String email);

    @Query("select u.id from User u where u.email = ?1")
    long findByEmailID(String email);

    @Query("select u.role from User u where u.email = ?1")
    String findByEmailRole(String email);

    @Query("select u.email from User u where u.email = ?1 AND u.password = ?2 ")
    String findByEmailAndPassword(String email, String password);

    @Query("select u from User u where u.email = ?1 AND u.confirmation = ?2 ")
    User findByEmailAndConfirmation(String email, String confirmation);

}
