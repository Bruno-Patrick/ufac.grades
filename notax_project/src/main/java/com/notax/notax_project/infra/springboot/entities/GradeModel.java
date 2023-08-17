package com.notax.notax_project.infra.springboot.entities;

import java.io.Serializable;

import com.notax.notax_project.domain.entities.Grade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "grade")
public class GradeModel implements Serializable {

    public GradeModel(Grade grade) {
        this.setId(grade.getId());
        this.setGrade(grade.getGrade());
        this.setStudent(new StudentModel(grade.getStudent()));
        this.setPartial(new PartialModel(grade.getPartial()));
        this.setWeight(grade.getWeight());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private Float grade;

    @ManyToOne
    @JoinColumn(nullable = false)
    private StudentModel student;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PartialModel partial;

    @Column(nullable = false)
    private Integer weight;

    public Grade toEntity() {
        return Grade
            .builder()
            .id(id)
            .grade(grade)
            .student(student.toEntity())
            .partial(partial.toEntity())
            .weight(weight)
            .build();
    }
}
