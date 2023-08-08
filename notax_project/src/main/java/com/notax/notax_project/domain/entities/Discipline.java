package com.notax.notax_project.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.notax.notax_project.domain.error.NullError;
import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.DisciplineModel;
import com.notax.notax_project.infra.entities.UserModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discipline {
    private Long id;
    private DisciplineModel.Periodicity periodicity;
    private DisciplineModel.Ordinals ordinal;
    private String name;
    private String description;
    private String organization;
    private final LocalDateTime createTime = LocalDateTime.now();
    private Boolean isActive;
    private UserModel user;
    private List<ClassModel> classList;

    public void setId(Long id) throws NullError {
        if (id == null) {
            throw new NullError("id");
        }
        this.id = id;
    }
    public void setPeriodicity(DisciplineModel.Periodicity periodicity) {
        this.periodicity = periodicity;
    }
    public void setOrdinal(DisciplineModel.Ordinals ordinal) {
        this.ordinal = ordinal;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public void setClassList(List<ClassModel> classList) {
        this.classList = classList;
    }
}
