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
        map.put(id.toString(), this.id);
        map.put(year.toString(), this.year);
        map.put(classIdent.toString(), this.classIdent);
        map.put(classIdentOrdinal.toString(), this.classIdentOrdinal);
        map.put(description.toString(), this.description);
        map.put(createTime.toString(), this.createTime);
        map.put(discipline.toString(), this.discipline);
        map.put(studentList.toString(), this.studentList);
        return map;
    }
}
