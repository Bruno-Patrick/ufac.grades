package com.notax.notax_project.infra.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClassModel implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = true)
    private Integer year;

    @Column(nullable = true)
    private Integer semester;

    @Column(nullable = true)
    private String description;

    @Column(updatable = false, nullable = false)
    private final LocalDateTime createTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(nullable = false)
    private DisciplineModel discipline;

    @OneToMany
    @JoinTable(
        name = "class_student",
        joinColumns = @JoinColumn(
            name = "class",
            nullable = false
        ),
        inverseJoinColumns = @JoinColumn(
            name = "student",
            nullable = false
        )
    )
    private List<StudentModel> studentsList;
}
