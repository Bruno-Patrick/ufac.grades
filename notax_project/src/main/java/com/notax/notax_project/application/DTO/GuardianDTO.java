package com.notax.notax_project.application.DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.domain.entities.Guardian;

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
public class GuardianDTO implements IDTO {
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

    public GuardianDTO(Guardian guardian) {
        setId(guardian.getId());
        setName(guardian.getName());
        setPhone(guardian.getPhone());
        setEmail(guardian.getEmail());

        setStudentsDTO(guardian.getStudentsList().stream().map(
            student -> new StudentDTO(student)
        ).collect(Collectors.toList()));
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("phone", this.phone);
        map.put("email", this.email);
        map.put("studentsDTO", this.studentsDTO);
        return map;
    }
}
