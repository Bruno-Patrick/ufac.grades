package com.notax.notax_project.DTO;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StudentDTO(
    Long id,
    String name,
    String phone,
    String email,
    @JsonProperty("disciplines") DisciplineDTO disciplinesDTO,
    @JsonProperty("guardians") List<GuardianDTO> guardiansDTO
) {
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.name.toString(), this.name);
        map.put(this.phone.toString(), this.phone);
        map.put(this.email.toString(), this.email);
        map.put(this.disciplinesDTO.toString(), this.disciplinesDTO);
        map.put(this.guardiansDTO.toString(), this.guardiansDTO);
        return map;
    }   
} 