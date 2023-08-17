package com.notax.notax_project.infra.springboot.entities;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

        this.setClassModel(student.getClasses().stream().map(
            entity -> new ClassModel(entity)
        ).collect(Collectors.toList()));

        this.setGuardiansList(student.getGuardians().stream().map(
            entity -> new GuardianModel(entity)
        ).collect(Collectors.toList()));
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

            .classes(classModel.stream().map(
                model -> model.toEntity()
            ).collect(Collectors.toList()))

            .guardians(guardiansList.stream().map(
                model -> model.toEntity()
            ).collect(Collectors.toList()))

            .build();
    }
}