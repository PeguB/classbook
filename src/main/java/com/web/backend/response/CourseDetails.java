package com.web.backend.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class CourseDetails {
    private Integer year;
    private Integer numberCredits;
    @NotBlank
    private String name;

    @JsonProperty("grades")
    private Map<String, List<Integer>> studentIdGrades;
    private String teacherId;

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
    public Map<String, List<Integer>> getStudentIdGrades() {
        return studentIdGrades;
    }

    public void setStudentIdGrades(@Nullable Map<String, List<Integer>> studentIdGrades) {
        this.studentIdGrades = studentIdGrades;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
