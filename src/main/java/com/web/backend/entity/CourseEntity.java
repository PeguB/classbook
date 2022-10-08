package com.web.backend.entity;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import javax.validation.constraints.NotNull;

@Document(collection = "courses")
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    @Id
    private ObjectId id;
    private Integer year;
    private Integer numberCredits;
    private String name;
    @Nullable
    private Map<String, List<Grades>> studentIdNotes;
    private String teacherId;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumberCredits() {
        return numberCredits;
    }

    public void setNumberCredits(Integer numberCredits) {
        this.numberCredits = numberCredits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public Map<String, List<Grades>> getStudentIdNotes() {
        return studentIdNotes;
    }

    public void setStudentIdNotes(@Nullable Map<String, List<Grades>> studentIdNotes) {
        this.studentIdNotes = studentIdNotes;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
