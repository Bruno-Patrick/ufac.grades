package com.notax.notax_project.application.DTO;

import java.util.HashMap;

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
public class PartialDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String description;
    @JsonProperty("class")
    ClassDTO classDTO;

   public HashMap<String, Object> toMap()  {
    HashMap<String, Object> map = new HashMap<>();
    map.put("id", this.id);
    map.put("title", this.title);
    map.put("description", this.description);
    map.put("classDTO", this.classDTO);
    return map;
   }
}
