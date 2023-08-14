package com.notax.notax_project.application.DTO;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.domain.entities.Grade;

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
public class GradeDTO implements IDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("grade")
    Float grade;
    @JsonProperty("student")
    StudentDTO student;
    @JsonProperty("partial")
    PartialDTO partial;
    @JsonProperty("weight")
    Integer weight;

    public GradeDTO(Grade grade) {
        setId(grade.getId());
        setGrade(grade.getGrade());
        setStudent(new StudentDTO(grade.getStudent()));
        setPartial(new PartialDTO(grade.getPartial()));
        setWeight(grade.getWeight());
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("grade", this.grade);
        map.put("student", this.student);
        map.put("partial", this.partial);
        map.put("weight", this.weight);
        return map;
    }
}
