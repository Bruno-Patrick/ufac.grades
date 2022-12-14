package com.notax.notax_project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Responsible implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long responsibleId;

    @Column(nullable = false)
    private String responsibleName;

    @Column(nullable = true)
    private String responsiblePhone;

    @Column(nullable = true)
    private String responsibleMail;

}
