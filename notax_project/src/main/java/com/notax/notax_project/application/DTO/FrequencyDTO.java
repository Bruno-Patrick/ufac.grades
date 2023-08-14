package com.notax.notax_project.application.DTO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.domain.entities.Frequency;

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
public class FrequencyDTO implements IDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("date")
    Date date;
    @JsonProperty("student")
    StudentDTO student;
    @JsonProperty("class")
    ClassDTO classDTO;

    public FrequencyDTO(Frequency frequency) {
        setId(frequency.getId());
        setDate(frequency.getDate());
        setStudent(new StudentDTO(frequency.getStudent()));
        setClassDTO(new ClassDTO(frequency.getScholarClass()));
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("date", this.date);
        map.put("student", this.student);
        map.put("classDTO", this.classDTO);
        return map;
    }
}
