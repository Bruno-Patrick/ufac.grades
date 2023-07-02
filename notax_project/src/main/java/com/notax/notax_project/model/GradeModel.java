package com.notax.notax_project.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private StudentModel student;
    
    @ManyToOne
    private DisciplineModel discipline;

    @ManyToOne
    private PartialModel partial;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Boolean isPartial;

    @Column(nullable = false)
    private Boolean isN1;

    @Column(nullable = false)
    private Boolean isN2;

    @Column(nullable = false)
    private Boolean isFinal;
}
