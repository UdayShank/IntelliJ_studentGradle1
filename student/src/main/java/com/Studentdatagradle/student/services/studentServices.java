package com.Studentdatagradle.student.services;

import com.Studentdatagradle.student.entity.Students;
import com.Studentdatagradle.student.repository.StdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class studentServices {
    @Autowired
    private StdRepository repository;

    public Students addStudents (Students students){
        students.setRoll(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(students);
    }

    public List<Students> findALlStudents(){

        return repository.findAll();
    }

    public Students findByroll (String roll){
        return repository.findById(roll).get();
    }

    public List<Students> getStudentByName(String Name){

        return repository.findByName(Name);
    }

    public String updateStudent(Students StudentRequest){


        Students existingStudents = repository.findById(StudentRequest.getRoll()).get();
        existingStudents.setName(StudentRequest.getName());
        existingStudents.setStandard(StudentRequest.getStandard());
        existingStudents.setSection(StudentRequest.getSection());
        repository.save(StudentRequest);
        return "Data Saved Successfully" ;
    }

    public String deleteStudent(String roll){
        repository.deleteById(roll);
        return roll+" Student data deleted from the School Data";
    }
}
