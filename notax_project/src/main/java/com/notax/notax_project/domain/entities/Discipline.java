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
    private LocalDateTime createTime;
    private Boolean isActive;
    private UserModel user;
    private List<ClassModel> classList;

    public void setCreateTime(LocalDateTime createTime) throws NullError {
        if (createTime == null) {
            throw new NullError("create time");
        }
        this.createTime = createTime;
    }
    public void setId(Long id) throws NullError {
        if (id == null) {
            throw new NullError("id");
        }
        this.id = id;
    }
    public void setPeriodicity(DisciplineModel.Periodicity periodicity) throws NullError {
        if (periodicity == null) {
            throw new NullError("periodicy");
        }
        this.periodicity = periodicity;
    }
    public void setOrdinal(DisciplineModel.Ordinals ordinal) throws NullError {
        if (ordinal == null) {
            throw new NullError("ordinal");
        }
        this.ordinal = ordinal;
    }
    public void setName(String name) throws NullError {
        if (name == null) {
            throw new NullError("name");
        }
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public void setIsActive(Boolean isActive) throws NullError {
        if (isActive == null) {
            throw new NullError("isActive");
        }
        this.isActive = isActive;
    }
    public void setUser(UserModel user) throws NullError {
        if (user == null) {
            throw new NullError("user");
        }
        this.user = user;
    }
    public void setClassList(List<ClassModel> classList) throws NullError {
        this.classList = classList;
    }
}
