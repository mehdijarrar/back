package com.associationsapp.repository;
import com.associationsapp.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository  extends JpaRepository<Service, Long> {
}
