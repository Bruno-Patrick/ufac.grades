package com.notax.notax_project.infra.springboot.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.notax.notax_project.domain.entities.Class;

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

    @Column(nullable = true)
    private String description;

    @Column(updatable = false, nullable = false)
    @Builder.Default
    private LocalDateTime createTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(nullable = false)
    private DisciplineModel discipline;

    @JoinColumn(nullable = false)
    @Builder.Default
    private Boolean isActive = true;

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

    public ClassModel(Class clazz) {
        this.setId(clazz.getId());
        this.setYear(clazz.getYear());
        this.setDescription(clazz.getDescription());
        this.setCreateTime(clazz.getCreateTime());
        this.setDiscipline(new DisciplineModel(clazz.getDiscipline()));
        this.setIsActive(clazz.getIsActive());

        this.setStudentsList(clazz.getStudentsList().stream().map(
            student -> new StudentModel(student)
        ).collect(Collectors.toList()));
    }

    public Class toEntity() {
        return Class
            .builder()
            .id(id)
            .year(year)
            .description(description)
            .createTime(createTime)
            .discipline(discipline.toEntity())
            .isActive(isActive)
            .studentsList(studentsList)
            .build();
    }
}
