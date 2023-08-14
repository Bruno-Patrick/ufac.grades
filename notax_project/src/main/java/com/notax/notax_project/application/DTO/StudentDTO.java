package com.notax.notax_project.application.DTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.domain.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO implements IDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("name")
    String name;
    @JsonProperty("phone")
    String phone;
    @JsonProperty("email")
    String email;
    @JsonProperty("classes_of_student")
    List<ClassDTO> classList;
    @JsonProperty("guardians_of_student")
    List<GuardianDTO> guardiansList;

    public StudentDTO(Student student) {
        setId(student.getId());
        setName(student.getName());
        setPhone(student.getPhone());
        setEmail(student.getEmail());

        setClassList(student.getClasses().stream().map(
            clazz -> new ClassDTO(clazz)
        ).collect(Collectors.toList()));

        setGuardiansList(student.getGuardians().stream().map(
            guardian -> new GuardianDTO(guardian)
        ).collect(Collectors.toList()));
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("phone", this.phone);
        map.put("email", this.email);
        map.put("classList", this.classList);
        map.put("guardiansList", this.guardiansList);
        return map;
    }
}