package com.web.backend.service;

import com.web.backend.entity.CourseEntity;
import com.web.backend.response.CourseDetails;
import com.web.backend.response.CourseSummary;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

     CourseEntity courseSummaryToCourseEntity(CourseSummary courseSummary);
    List<CourseDetails> coursesEntityToCoursesSummary(List<CourseEntity> courseEntityList);
}
