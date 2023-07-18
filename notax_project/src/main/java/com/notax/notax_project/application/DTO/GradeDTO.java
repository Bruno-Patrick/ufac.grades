package com.notax.notax_project.application.DTO;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.infra.enums.GradeIdentEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("grade")
    Float grade;
    @JsonProperty("student")
    StudentDTO student;
    @JsonProperty("class")
    ClassDTO classDTO;
    @JsonProperty("partial")
    PartialDTO partial;
    @JsonProperty("weight")
    Integer weight;
    @JsonProperty("grade_identificator")
    GradeIdentEnum gradeIdentificator;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.grade.toString(), this.grade);
        map.put(this.student.toString(), this.student);
        map.put(this.classDTO.toString(), this.classDTO);
        map.put(this.partial.toString(), this.partial);
        map.put(this.weight.toString(), this.weight);
        map.put(this.gradeIdentificator.toString(), this.gradeIdentificator);
        return map;
    }
}
