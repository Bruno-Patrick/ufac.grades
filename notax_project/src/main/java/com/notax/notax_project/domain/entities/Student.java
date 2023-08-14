package com.notax.notax_project.domain.entities;

import java.util.List;

import com.notax.notax_project.domain.error.NotEmptyError;
import com.notax.notax_project.domain.error.NullError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Student {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private List<Discipline> disciplines;
    private List<Class> classes;
    private List<Guardian> guardians;

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) throws NullError, NotEmptyError {
        if (name == null) {
            throw new NullError("name");
        }
        if (name.length() == 0) {
            throw new NotEmptyError("name");
        }
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDisciplinesList(List<Discipline> disciplinesList) {
        this.disciplines = disciplinesList;
    }
    public void setClassModel(List<Class> classModel) {
        this.classes = classModel;
    }
    public void setGuardiansList(List<Guardian> guardiansList) {
        this.guardians = guardiansList;
    }



}
