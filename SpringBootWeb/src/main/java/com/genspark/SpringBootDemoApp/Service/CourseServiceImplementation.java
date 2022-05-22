package com.genspark.SpringBootDemoApp.Service;

import com.genspark.SpringBootDemoApp.DAO.CourseDAO;
import com.genspark.SpringBootDemoApp.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService {
    @Autowired // always autowired for dependencies
    private CourseDAO courseDAO;

    @Override
    public List<Course> getAllCourse() {
        return this.courseDAO.findAll();
    }

    @Override
    public Course getCourseById(int courseID) {
        Optional<Course> c = this.courseDAO.findById(courseID);
        Course course; // if courseID is present in database.
        if (c.isPresent()) {

            course = c.get();
        }
        else{
            throw new RuntimeException("Course not found for id : : " + courseID);
        }
        return course;
    }

    @Override // adding new data to database
    public Course addCourse(Course course) {
        return this.courseDAO.save(course);
    }

    @Override // updating data to database
    public Course updateCourse(Course course) {
       return this.courseDAO.save(course);
    }

    @Override // deletes the id from database
    public String deleteCourseById(int courseID) {
        this.courseDAO.deleteById(courseID);
        return "Deleted Successfully";
    }
}
