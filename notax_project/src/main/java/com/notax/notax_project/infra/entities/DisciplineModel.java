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
@Table(name = "discipline")
public class DisciplineModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String organization;

    @Column(nullable = false, updatable = false)
    private final LocalDateTime createTime = LocalDateTime.now();

    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserModel user;

    @OneToMany
    @JoinTable(
        name = "discipline_class",
        joinColumns = @JoinColumn(
            name = "discipline",
            nullable = false
        ),
        inverseJoinColumns = @JoinColumn(
            name = "class",
            nullable = false
        )
    )
    @JoinColumn(nullable = false)
    private List<ClassModel> classList;
}