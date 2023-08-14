package com.notax.notax_project.application.DTO;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notax.notax_project.domain.entities.Partial;

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
public class PartialDTO implements IDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String description;
    @JsonProperty("class")
    ClassDTO classDTO;

    public PartialDTO(Partial partial) {
        setId(partial.getId());
        setTitle(partial.getTitle());
        setDescription(partial.getDescription());
        setClassDTO(new ClassDTO(partial.getScholarClass()));
    }

   public Map<String, Object> toMap()  {
    Map<String, Object> map = new HashMap<>();
    map.put("id", this.id);
    map.put("title", this.title);
    map.put("description", this.description);
    map.put("classDTO", this.classDTO);
    return map;
   }
}
