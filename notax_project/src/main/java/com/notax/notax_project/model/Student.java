package com.notax.notax_project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Student implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer register;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String email;

    @ManyToOne(optional = true)
    private Responsible responsible_of_student;

    @Column(nullable = false)
    private Boolean student_active = true;

}
