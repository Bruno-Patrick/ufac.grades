package com.notax.notax_project.infra.springboot.entities;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.notax.notax_project.domain.entities.Guardian;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "guardian")
public class GuardianModel implements Serializable {

    public GuardianModel(Guardian guardian) {
        this.setId(guardian.getId());
        this.setName(guardian.getName());
        this.setPhone(guardian.getPhone());
        this.setEmail(guardian.getEmail());
        this.setStudentsList(guardian.getStudentsList().stream().map(
            entity -> new StudentModel(entity)
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

    @OneToMany(mappedBy = "guardiansList")
    private List<StudentModel> studentsList;

    public Guardian toEntity() {
        return Guardian
            .builder()
            .id(id)
            .name(name)
            .phone(phone)
            .email(email)
            .studentsList(studentsList.stream().map(
                model -> model.toEntity()
            ).collect(Collectors.toList()))
            .build();
    }
}
