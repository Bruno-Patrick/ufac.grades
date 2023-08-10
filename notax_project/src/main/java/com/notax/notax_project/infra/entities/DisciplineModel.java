package com.notax.notax_project.infra.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.notax.notax_project.domain.entities.Discipline;

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
    public enum Periodicity {
        MONTHLY,
        BIMONTHLY,
        TRIMONTHLY,
        QUADRIMONTHLY,
        SEMESTERLY,
        ANUAL
    }

    public enum Ordinals {
        TH_1,
        TH_2,
        TH_3,
        TH_4,
        TH_5,
        TH_6,
        TH_7,
        TH_8,
        TH_9,
        TH_10,
        TH_11,
        TH_12
    }

    public DisciplineModel(Discipline discipline) {
        this.setId(discipline.getId());
        this.setPeriodicity(discipline.getPeriodicity());
        this.setOrdinal(discipline.getOrdinal());
        this.setName(discipline.getName());
        this.setDescription(discipline.getDescription());
        this.setOrganization(discipline.getOrganization());
        this.setCreateTime(discipline.getCreateTime());
        this.setIsActive(discipline.getIsActive());
        this.setUser(discipline.getUser());
        this.setClassList(discipline.getClassList());
    }

    public DisciplineModel(
        Long id,
        Periodicity periodicity,
        Ordinals ordinal,
        String name,
        String description,
        String organization,
        UserModel user,
        List<ClassModel> classList
        ) {
        this.id = id;
        this.periodicity = periodicity;
        this.ordinal = ordinal;
        this.name = name;
        this.description = description;
        this.organization = organization;
        this.user = user;
        this.classList = classList;
        this.setCreateTime(LocalDateTime.now());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private DisciplineModel.Periodicity periodicity;

    @Column(nullable = false)
    private DisciplineModel.Ordinals ordinal;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String organization;

    @Column(nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime createTime = LocalDateTime.now();

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
    private List<ClassModel> classList;

    public Discipline toEntity() {
        return Discipline
            .builder()
            .id(id)
            .periodicity(periodicity)
            .ordinal(ordinal)
            .name(name)
            .description(description)
            .organization(organization)
            .createTime(createTime)
            .isActive(isActive)
            .user(user)
            .classList(classList)
            .build();
    }
}