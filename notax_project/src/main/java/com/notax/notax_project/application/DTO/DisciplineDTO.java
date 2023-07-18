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
        map.put(this.id.toString(), this.id);
        map.put(this.name.toString(), this.name);
        map.put(this.description.toString(), this.description);
        map.put(this.organization.toString(), this.organization);
        map.put(this.createTime.toString(), this.createTime);
        map.put(this.isActive.toString(), this.isActive);
        map.put(this.user.toString(), this.user);
        map.put(this.classList.toString(), this.classList);
        return map;
    }
}
