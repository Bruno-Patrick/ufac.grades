package com.notax.notax_project.application.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClassDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("year")
    Integer year;
}
