package com.notax.notax_project.application.DTO;

import java.util.HashMap;
import java.util.List;

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
public class GuardianDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("name")
    String name;
    @JsonProperty("phone")
    String phone;
    @JsonProperty("email")
    String email;
    @JsonProperty("students_of_guardian")
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
