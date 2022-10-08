package com.web.backend.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class StudentEntity {

    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private Integer universityYear;
    private String username;
    private String studentNumber;
    private List<String> assignedCoursesId;

}
