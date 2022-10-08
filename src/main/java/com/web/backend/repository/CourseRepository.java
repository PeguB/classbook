package com.web.backend.repository;

import com.web.backend.entity.CourseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends MongoRepository<CourseEntity, ObjectId> {
    Optional<CourseEntity> findByName(String name);
}
