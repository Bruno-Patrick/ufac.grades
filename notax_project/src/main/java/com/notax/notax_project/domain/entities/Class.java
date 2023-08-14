package com.notax.notax_project.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.notax.notax_project.domain.error.NullError;
import com.notax.notax_project.infra.springboot.entities.DisciplineModel;
import com.notax.notax_project.infra.springboot.entities.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Class {
    private Long id;
    private Integer year;
    private String description;
    private LocalDateTime createTime;
    private Discipline discipline;
    private Boolean isActive;
    private List<Student> studentsList;

    public void setId(Long id) throws NullError {
        if (id == null) {
            throw new NullError("id");
        }
        this.id = id;
    }
    public void setYear(Integer year) throws NullError {
        if (year == null) {
            throw new NullError("year");
        }
        this.year = year;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreateTime(LocalDateTime createTime) throws NullError {
        if (createTime == null) {
            throw new NullError("creation time");
        }
        this.createTime = createTime;
    }
    public void setDiscipline(Discipline discipline) throws NullError {
        if (discipline == null) {
            throw new NullError("discipline");
        }
        this.discipline = discipline;
    }
    public void setIsActive(Boolean isActive) throws NullError {
        if (isActive == null) {
            throw new NullError("isActive");
        }
        this.isActive = isActive;
    }
    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
