package com.Studentdatagradle.student.controller;

import com.Studentdatagradle.student.entity.Students;
import com.Studentdatagradle.student.services.studentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private studentServices services;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Students CreateStudent (@RequestBody Students students){
        return services.addStudents(students);
    }

    @GetMapping
    public List<Students> GetStudents(){
        return services.findALlStudents();
    }

    @GetMapping("/name")
    public List<Students> getStudents(@PathVariable String StudentName){
        return  services.getStudentByName(StudentName);
    }

    @PutMapping
    public String updateStudent(@RequestBody Students students) {
        return services.updateStudent(students);
    }

    @DeleteMapping("/{roll}")
    public String DeleteStudent (@PathVariable String roll){
        return services.deleteStudent(roll);
    }
}
