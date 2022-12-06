package com.Studentdatagradle.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    private String roll;
    private String Name;
    private String Standard;
    private String Section;
}
