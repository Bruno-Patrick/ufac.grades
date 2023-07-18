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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
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

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.name.toString(), this.name);
        map.put(this.phone.toString(), this.phone);
        map.put(this.email.toString(), this.email);
        map.put(this.classList.toString(), this.classList);
        map.put(this.guardiansList.toString(), this.guardiansList);
        return map;
    }   
} 