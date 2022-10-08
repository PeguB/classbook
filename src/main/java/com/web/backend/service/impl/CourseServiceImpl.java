package com.web.backend.service.impl;

import com.web.backend.entity.CourseEntity;
import com.web.backend.entity.Grades;
import com.web.backend.exception.CourseExistException;
import com.web.backend.repository.CourseRepository;
import com.web.backend.response.CourseDetails;
import com.web.backend.response.CourseSummary;
import com.web.backend.service.CourseMapper;
import com.web.backend.service.CourseService;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final  CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity addCourse(CourseSummary course) {
        if(courseRepository.findByName(course.getName()).isPresent()){
            throw new CourseExistException();
        }
        CourseEntity entity = CourseMapper.INSTANCE.courseSummaryToCourseEntity(course);
        courseRepository.save(entity);
        return new ResponseEntity<>(entity,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CourseDetails>> findAllCourse() {
        List<CourseDetails> courseDetails = CourseMapper.INSTANCE.coursesEntityToCoursesSummary(courseRepository.findAll());
        return new ResponseEntity<>(courseDetails,HttpStatus.OK);
    }

    @Override
    public ResponseEntity addGrade(String courseName,String studentNumber, List<Grades> grades) {
        courseRepository.findByName(courseName)
                .ifPresentOrElse(courseEntity -> {
                    courseEntity.getStudentIdNotes().
                            get(studentNumber).addAll(grades);
                }, ()->{throw new CourseExistException();});
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
