package com.notax.notax_project.infra.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "partial")
public class PartialModel implements Serializable {
    public enum PartialType {
        ACTIVITY,
        SEMINARY,
        EXAM
    }

    public enum PartialTime {
        N1,
        N2,
        FINAL,
        RECOVERY
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ClassModel scholarClass;

    @Column(nullable = false)
    private PartialModel.PartialType partialType;

    @Column(nullable = false)
    private PartialModel.PartialTime partialTime;
}
