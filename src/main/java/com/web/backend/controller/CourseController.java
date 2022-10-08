package com.web.backend.controller;

import com.web.backend.entity.Grades;
import com.web.backend.response.CourseSummary;
import com.web.backend.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/course")
public class CourseController {


    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping()
    private ResponseEntity addCourse(@RequestBody @Valid CourseSummary courseSummary){
        return courseService.addCourse(courseSummary);
    }
    @GetMapping
    private ResponseEntity findAllCourse(){
        return courseService.findAllCourse();
    }
    @PostMapping("/addGrade")
    private ResponseEntity addGrade(@RequestBody List<Grades> grades,
                                    @RequestParam(name = "number") Integer studentNumber,
                                    @RequestParam(name = "name") String courseName) {
        return courseService.addGrade(courseName,studentNumber.toString(),grades);
    }
}
