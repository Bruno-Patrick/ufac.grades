package com.notax.notax_project.domain.entities;

import java.util.Date;

import com.notax.notax_project.domain.error.NullError;
import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Frequency {
    private Long id;
    private Date date;
    private StudentModel student;
    private ClassModel scholarClass;

    public void setId(Long id) throws NullError {
        if (id == null) {
            throw new NullError("id");
        }
        this.id = id;
    }
    public void setDate(Date date) throws NullError {
        if (date == null) {
            throw new NullError("date");
        }
        this.date = date;
    }
    public void setStudent(StudentModel student) throws NullError {
        if (student == null) {
            throw new NullError("student");
        }
        this.student = student;
    }
    public void setScholarClass(ClassModel scholarClass) throws NullError {
        if (scholarClass == null) {
            throw new NullError("class");
        }
        this.scholarClass = scholarClass;
    }
}
