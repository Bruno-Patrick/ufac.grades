package com.notax.notax_project.application.DTO;

import java.util.Date;
import java.util.HashMap;

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
    Long id;
    DisciplineDTO discipline;
    Date date;
    StudentDTO student;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.date.toString(), this.date);
        map.put(this.student.toString(), this.student);
        map.put(this.discipline.toString(), this.discipline);
        return map;
    }
}
