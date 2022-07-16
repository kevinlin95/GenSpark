package com.example.App.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Kevin Lin"),
            new Student(2, "Billy Lin"),
            new Student(3, "Danny Lin")
    );

    @GetMapping(path="/students")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    // hasRole, hasAnyRole, hasAuthority, hasAnyAuthority
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @PostMapping(path="{studentId}")
    @PreAuthorize("hasAuthority('admin:write')")
    public void registerNewStudent(Student student){
        System.out.println(student);
    }

    @DeleteMapping(path="{studentId}")
    @PreAuthorize("hasAuthority('student:delete')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping(path="{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println(String.format("%s %s", studentId, student));
    }
}
