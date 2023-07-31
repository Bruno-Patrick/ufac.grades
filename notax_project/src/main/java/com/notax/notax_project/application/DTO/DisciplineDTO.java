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
    @JsonProperty("id")
    Long id;
    @JsonProperty("name")
    String name;
    @JsonProperty("description")
    String description;
    @JsonProperty("organization")
    private String organization;
    @JsonProperty(value = "create_time", access = Access.READ_ONLY) 
    LocalDateTime createTime;
    @JsonProperty(value = "is_active")
    Boolean isActive;
    @JsonProperty("user_has_created_discipline")
    UserDTO user;
    @JsonProperty("list_of_classes")
    List<ClassDTO> classList;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("description", this.description);
        map.put("organization", this.organization);
        map.put("createTime", this.createTime);
        map.put("isActive", this.isActive);
        map.put("user", this.user);
        map.put("classList", this.classList);
        return map;
    }
}
