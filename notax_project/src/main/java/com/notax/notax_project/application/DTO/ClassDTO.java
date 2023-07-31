package com.notax.notax_project.application.DTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.infra.enums.ClassIdentEnum;
import com.notax.notax_project.infra.enums.OrdinalsEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClassDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("class_identificator")
    private ClassIdentEnum classIdent;
    @JsonProperty("th")
    private OrdinalsEnum classIdentOrdinal;
    @JsonProperty("description")    
    private String description;
    @JsonProperty("create_time")
    private final LocalDateTime createTime;
    @JsonProperty("discipline")
    private DisciplineDTO discipline;
    @JsonProperty("students_of_class")
    private List<StudentDTO> studentList;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("year", this.year);
        map.put("classIdent", this.classIdent);
        map.put("classIdentOrdinal", this.classIdentOrdinal);
        map.put("description", this.description);
        map.put("createTime", this.createTime);
        map.put("discipline", this.discipline);
        map.put("studentList", this.studentList);
        return map;
    }
}
