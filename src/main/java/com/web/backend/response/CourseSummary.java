package com.web.backend.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseSummary {

    @NotNull
    private Integer year;
    @NotNull
    private Integer numberCredits;
    @NotBlank
    private String name;

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
}
