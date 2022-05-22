package com.genspark.SpringBootDemoApp.DAO;

import com.genspark.SpringBootDemoApp.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {
}
