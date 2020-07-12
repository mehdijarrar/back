package com.associationsapp.repository;
import com.associationsapp.model.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRegistrationRepository  extends JpaRepository<CourseRegistration, Long> {
}
