package com.genspark.SpringBootDemoApp.Controller;

import com.genspark.SpringBootDemoApp.Entity.Course;
import com.genspark.SpringBootDemoApp.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService service;

    // setting params -> localhost:8080/home?name=kevin
    //@RequestMapping("/home")
    public String home(@RequestParam(value = "name", defaultValue="World")
                           String name,
                       @RequestParam(value = "msg", defaultValue="Good Morning")
                           String msg){
        return "Hello" + name + "!" + msg;
    }
    // setting url
    // Other methods -> @PutMapping, @DeleteMapping,
    @GetMapping("/") // sets the page for that -> localhost:8080/abc
    public String hello(){
        return "<HTML><H1>Welcome to my First Boot Application </H1></HTML>";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.service.getAllCourse();
    }

    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID){
        return this.service.getCourseById(Integer.parseInt(courseID));
    }

    @PostMapping("/courses") //Adding method
    public Course addCourse(@RequestBody Course course){
        return this.service.addCourse(course);
    }

    @PutMapping("/courses") //Update method
    public Course updateCourse(@RequestBody Course course){
        return this.service.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseID}")
    public String deleteCourse(@PathVariable String courseID){
        return this.service.deleteCourseById(Integer.parseInt(courseID));
    }
}
