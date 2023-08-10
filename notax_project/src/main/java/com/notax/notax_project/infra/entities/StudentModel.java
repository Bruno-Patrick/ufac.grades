package com.notax.notax_project.infra.entities;

import java.io.Serializable;
import java.util.List;

import com.notax.notax_project.domain.entities.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class StudentModel implements Serializable {

    public StudentModel(Student student) {
        this.setId(student.getId());
        this.setName(student.getName());
        this.setPhone(student.getPhone());
        this.setEmail(student.getEmail());
        this.setDisciplinesList(student.getDisciplinesList());
        this.setClassModel(student.getClassModel());
        this.setGuardiansList(student.getGuardiansList());
    }

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
    private List<ClassModel> disciplinesList;

    @OneToMany(mappedBy = "studentsList")
    private List<ClassModel> classModel;

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

    public Student toEntity() {
        return Student
            .builder()
            .id(id)
            .name(name)
            .phone(phone)
            .email(email)
            .disciplinesList(disciplinesList)
            .classModel(classModel)
            .guardiansList(guardiansList)
            .build();
    }
}