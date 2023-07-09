package com.notax.notax_project.infra.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String phone;

    @Column(nullable =  true)
    private String email;

    @OneToMany(mappedBy = "studentsList")
    private List<DisciplineModel> disciplinesList;

    @OneToMany
    @JoinTable(
        name = "student_guardian",
        joinColumns = @JoinColumn(
            name = "student",
            nullable = false
        ),
        inverseJoinColumns = @JoinColumn(
            name = "guardian",
            nullable = false
        )
    )
    @JoinColumn(nullable = true)
    private List<GuardianModel> guardiansList;

    @OneToMany(mappedBy = "student")
    private List<FrequencyModel> frequencies;
}