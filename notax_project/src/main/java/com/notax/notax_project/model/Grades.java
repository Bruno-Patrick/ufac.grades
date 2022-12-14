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
public class Grades implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long gradesId;

    @Column(nullable = false)
    private Float gradesValue;

    @ManyToOne
    @JoinColumn(name = "partialId", nullable = false)
    private Partial partialId;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student studentId;

}
