package com.web.backend.repository;

import com.web.backend.entity.TeacherEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<TeacherEntity, ObjectId> {

}
