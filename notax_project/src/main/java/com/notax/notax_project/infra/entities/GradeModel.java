package com.notax.notax_project.infra.entities;

import java.io.Serializable;

import com.notax.notax_project.infra.enums.GradeIdentEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grade")
public class GradeModel implements Serializable {
    
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
    private DisciplineModel discipline;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PartialModel partial;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private GradeIdentEnum gradeIdentificator;
}
