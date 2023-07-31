package com.notax.notax_project.application.DTO;

import java.util.Date;
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
public class FrequencyDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("date")
    Date date;
    @JsonProperty("student")
    StudentDTO student;
    @JsonProperty("class")
    ClassDTO classDTO;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("date", this.date);
        map.put("student", this.student);
        map.put("classDTO", this.classDTO);
        return map;
    }
}
