package com.notax.notax_project.application.DTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class DisciplineDTO {
    Long id;
    String name;
    Integer year;
    Integer semester;
    String description;
    @JsonProperty(value = "create_time", access = Access.READ_ONLY) 
    LocalDateTime createTime;
    @JsonProperty(value = "is_active")
    Boolean isActive;
    UserDTO user;
    @JsonProperty("students")
    List<StudentDTO> studentsList;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.name.toString(), this.name);
        map.put(this.year.toString(), this.year);
        map.put(this.semester.toString(), this.semester);
        map.put(this.description.toString(), this.description);
        map.put(this.createTime.toString(), this.createTime);
        map.put(this.isActive.toString(), this.isActive);
        map.put(this.user.toString(), this.user);
        map.put(this.studentsList.toString(), this.studentsList);
        return map;
    }
}
