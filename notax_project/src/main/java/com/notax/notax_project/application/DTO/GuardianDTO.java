package com.notax.notax_project.application.DTO;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuardianDTO {
    Long id;
    String name;
    String phone;
    String email;
    @JsonProperty("students")
    List<StudentDTO> studentsDTO;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.name.toString(), this.name);
        map.put(this.phone.toString(), this.phone);
        map.put(this.email.toString(), this.email);
        map.put(this.studentsDTO.toString(), this.studentsDTO);
        return map;
    }
}
