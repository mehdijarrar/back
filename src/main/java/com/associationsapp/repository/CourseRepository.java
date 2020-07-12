package com.associationsapp.repository;

import com.associationsapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository  extends JpaRepository<Course, Long>  {
}
