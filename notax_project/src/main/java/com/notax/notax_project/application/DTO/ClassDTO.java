package com.notax.notax_project.application.DTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.domain.entities.Class;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClassDTO implements IDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("description")
    private String description;
    @JsonProperty("create_time")
    private LocalDateTime createTime;
    @JsonProperty("discipline")
    private DisciplineDTO discipline;
    @JsonProperty("students_of_class")
    private List<StudentDTO> studentList;

    public ClassDTO(Class clazz) {
        setId(clazz.getId());
        setYear(clazz.getYear());
        setDescription(clazz.getDescription());
        setCreateTime(clazz.getCreateTime());
        setDiscipline(new DisciplineDTO(clazz.getDiscipline()));

        setStudentList(clazz.getStudentsList().stream().map(
            student -> new StudentDTO(student)
        ).collect(Collectors.toList()));
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("year", this.year);
        map.put("description", this.description);
        map.put("createTime", this.createTime);
        map.put("discipline", this.discipline);
        map.put("studentList", this.studentList);
        return map;
    }
}
