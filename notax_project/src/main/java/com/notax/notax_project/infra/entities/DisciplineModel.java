package com.notax.notax_project.infra.entities;

import java.io.Serializable;
import java.util.Date;
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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    private Integer year;

    @Column(nullable = true)
    private Integer semester;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false, updatable = false)
    private Date createTime;

    @Column(nullable = false)
    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserModel user;

    @OneToMany
    @JoinTable(name = "discipline_student",
               joinColumns = @JoinColumn(name = "discipline",
                                         nullable = false
                             ),
               inverseJoinColumns = @JoinColumn(name = "student",
                                                nullable = false
                                    )
    )
    @JoinColumn(nullable = true)
    private List<StudentModel> studentsList;

    @OneToMany(mappedBy = "discipline")
    private List<FrequencyModel> frequecies;
}
