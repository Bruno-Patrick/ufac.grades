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

@Getter
@Setter
@Entity
public class Participate implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long participateId;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "disciplineId", nullable = false)
    private Discipline disciplineId;

}
