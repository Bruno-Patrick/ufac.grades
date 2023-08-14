package com.notax.notax_project.domain.entities;

import java.util.Objects;

import com.notax.notax_project.domain.error.NullError;
import com.notax.notax_project.infra.springboot.entities.PartialModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partial {
    private Long id;
    private String title;
    private String description;
    private Class scholarClass;
    private PartialModel.PartialType partialType;
    private PartialModel.PartialTime partialTime;

    public void setPartialType(PartialModel.PartialType partialType) throws NullError {
        if (partialType == null) {
            throw new NullError("partialType");
        }
        this.partialType = partialType;
    }
    public void setPartialTime(PartialModel.PartialTime partialTime) throws NullError {
        if (partialTime == null) {
            throw new NullError("partialTime");
        }
        this.partialTime = partialTime;
    }
    public void setId(Long id) throws NullError {
        if (id == null) {
            throw new NullError("id");
        }
        this.id = id;
    }
    public void setTitle(String title) throws NullError {
        if (title == null) {
            throw new NullError("title");
        }
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setScholarClass(Class scholarClass) throws NullError {
        if (Objects.isNull(scholarClass)) {
            throw new NullError("class");
        }
        this.scholarClass = scholarClass;
    }
}
