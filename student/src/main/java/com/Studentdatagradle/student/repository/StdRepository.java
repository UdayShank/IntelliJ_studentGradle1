package com.Studentdatagradle.student.repository;

import com.Studentdatagradle.student.entity.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StdRepository extends MongoRepository<Students, String> {
    List<Students> findByName(String Name);
}
