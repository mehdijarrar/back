package com.associationsapp.repository;
import com.associationsapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Long>{

}
