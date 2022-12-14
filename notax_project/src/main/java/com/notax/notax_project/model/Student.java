package com.notax.notax_project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Student implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonProperty("id")
    private Long studentId;

    @Column(nullable = false)
    @JsonProperty("nome")
    private String studentName;

    @Column(nullable = true)
    @JsonProperty("telefone")
    private String studentPhone;

    @Column(nullable = true)
    @JsonProperty(value = "email")
    private String studentEmail;

    @Column(nullable = false)
    @JsonProperty("matricula")
    private String studentRegister;

    @ManyToOne(optional = true)
    @JoinColumn(name = "responsibleId", nullable = true)
    @JsonProperty("responsavel")
    private Responsible studentResponsible;

    @Column(nullable = false)
    @JsonProperty("ativo")
    private Boolean studentActive = true;

    @Column(nullable = false)
    @JsonProperty("timestamp")
    private Date studentAccountCreationTimestamp;

}
