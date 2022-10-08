package com.web.backend.response;

import com.web.backend.entity.Grades;
import lombok.Data;

import java.util.List;

@Data
public class AddCourseDto {
    private String courseName;
    private String studentNumber;
    private List<Grades> grades;
}
