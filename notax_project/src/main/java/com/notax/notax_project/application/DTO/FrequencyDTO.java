package com.notax.notax_project.application.DTO;

import java.util.Date;
import java.util.HashMap;

public record FrequencyDTO(
    Long id,
    Date date,
    StudentDTO student,
    DisciplineDTO discipline
) {
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.date.toString(), this.date);
        map.put(this.student.toString(), this.student);
        map.put(this.discipline.toString(), this.discipline);
        return map;
    }
}
