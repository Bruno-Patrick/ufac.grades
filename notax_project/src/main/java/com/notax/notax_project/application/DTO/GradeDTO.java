package com.notax.notax_project.application.DTO;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.domain.enums.GradeIdentEnum;

public record GradeDTO(
    Long id,
    Float grade,
    StudentDTO student,
    DisciplineDTO discipline,
    PartialDTO partial,
    Integer weight,
    @JsonProperty("grade_identificator") GradeIdentEnum gradeIdentificator
) {
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.grade.toString(), this.grade);
        map.put(this.student.toString(), this.student);
        map.put(this.discipline.toString(), this.discipline);
        map.put(this.partial.toString(), this.partial);
        map.put(this.weight.toString(), this.weight);
        map.put(this.gradeIdentificator.toString(), this.gradeIdentificator);
        return map;
    }
}
