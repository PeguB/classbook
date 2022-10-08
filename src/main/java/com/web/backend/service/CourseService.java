package com.web.backend.service;


import com.web.backend.entity.Grades;
import com.web.backend.response.AddCourseDto;
import com.web.backend.response.CourseDetails;
import com.web.backend.response.CourseSummary;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    ResponseEntity addCourse(CourseSummary course);
    ResponseEntity<List<CourseDetails>> findAllCourse();
    ResponseEntity addGrade(String courseName,String studentNumber, List<Grades> grades);
}
