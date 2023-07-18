package com.notax.notax_project.infra.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.notax.notax_project.infra.enums.ClassIdentEnum;
import com.notax.notax_project.infra.enums.OrdinalsEnum;

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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassModel implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private ClassIdentEnum classIdent;

    @Column(nullable = false)
    private OrdinalsEnum classIdentOrdinal;

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
