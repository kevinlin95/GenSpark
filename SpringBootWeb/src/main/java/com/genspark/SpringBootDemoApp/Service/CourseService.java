package com.genspark.SpringBootDemoApp.Service;

import com.genspark.SpringBootDemoApp.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseService {

    List<Course> getAllCourse();
    Course getCourseById(int courseID);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    String deleteCourseById(int courseID);


}
