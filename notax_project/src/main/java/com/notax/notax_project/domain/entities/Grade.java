package com.notax.notax_project.domain.entities;

import com.notax.notax_project.domain.error.NullError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grade {
    private Long id;
    private Float grade;
    private Student student;
    private Partial partial;
    private Integer weight;

    public void setId(Long id) throws NullError {
        if (id == null) {
            throw new NullError("id");
        }
        this.id = id;
    }
    public void setGrade(Float grade) throws NullError {
        if (grade == null) {
            throw new NullError("id");
        }
        this.grade = grade;
    }
    public void setStudent(Student student) throws NullError {
        if (student == null) {
            throw new NullError("id");
        }
        this.student = student;
    }
    public void setPartial(Partial partial) throws NullError {
        if (partial == null) {
            throw new NullError("id");
        }
        this.partial = partial;
    }
    public void setWeight(Integer weight) throws NullError {
        if (weight == null) {
            throw new NullError("id");
        }
        this.weight = weight;
    }
}
