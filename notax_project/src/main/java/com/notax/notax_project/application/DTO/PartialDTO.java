package com.notax.notax_project.application.DTO;

import java.util.HashMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PartialDTO {
    Long id;
    String title;
    String description;
    DisciplineDTO discipline;

   public HashMap<String, Object> toMap()  {
    HashMap<String, Object> map = new HashMap<>();
    map.put(this.id.toString(), this.id);
    map.put(this.title.toString(), this.title);
    map.put(this.description.toString(), this.description);
    map.put(this.discipline.toString(), this.discipline);
    return map;
   }
}
