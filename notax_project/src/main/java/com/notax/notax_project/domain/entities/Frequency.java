package com.notax.notax_project.domain.entities;

import java.util.Date;

import com.notax.notax_project.domain.error.NullError;

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
    private Student student;
    private Class scholarClass;

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
    public void setStudent(Student student) throws NullError {
        if (student == null) {
            throw new NullError("student");
        }
        this.student = student;
    }
    public void setScholarClass(Class scholarClass) throws NullError {
        if (scholarClass == null) {
            throw new NullError("class");
        }
        this.scholarClass = scholarClass;
    }
}
