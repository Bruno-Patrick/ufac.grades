package com.notax.notax_project.application.DTO;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("grade", this.grade);
        map.put("student", this.student);
        map.put("classDTO", this.classDTO);
        map.put("partial", this.partial);
        map.put("weight", this.weight);
        return map;
    }
}
