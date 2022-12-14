package com.notax.notax_project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Discipline implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long disciplineId;

    @Column(nullable = false)
    private String disciplineName;
    
    @Column(nullable = false)
    private Integer disciplineYear;
    
    @Column(nullable = false)
    private Integer disciplineSemester;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacherId", nullable = false)
    private Teacher teacherId;
}
