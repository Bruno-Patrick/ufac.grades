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
    private Long grades_id;

    @Column(nullable = false)
    private Float grades_value;

    @ManyToOne
    @JoinColumn(name = "partial_id", nullable = false)
    private Partial partial_id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student_id;

}
