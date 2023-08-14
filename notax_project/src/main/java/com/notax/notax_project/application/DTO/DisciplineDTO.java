package com.notax.notax_project.application.DTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.notax.notax_project.domain.entities.Discipline;

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
public class DisciplineDTO implements IDTO {
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

    public DisciplineDTO(Discipline discipline) {
        setId(discipline.getId());
        setName(discipline.getName());
        setDescription(discipline.getDescription());
        setOrganization(discipline.getOrganization());
        setCreateTime(discipline.getCreateTime());
        setIsActive(discipline.getIsActive());
        setUser(new UserDTO(discipline.getUser()));

        setClassList(discipline.getClassList().stream().map(
            clazz -> new ClassDTO(clazz)
        ).collect(Collectors.toList()));
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
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
