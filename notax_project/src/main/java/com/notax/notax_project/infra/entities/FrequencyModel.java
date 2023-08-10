package com.notax.notax_project.infra.entities;

import java.util.Date;

import com.notax.notax_project.domain.entities.Frequency;

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
@Table(name = "frequency")
public class FrequencyModel {

    public FrequencyModel(Frequency frequency) {
        this.setId(frequency.getId());
        this.setDate(frequency.getDate());
        this.setStudent(frequency.getStudent());
        this.setScholarClass(frequency.getScholarClass());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(nullable = false)
    private StudentModel student;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ClassModel scholarClass;

    public Frequency toEntity() {
        return Frequency
            .builder()
            .id(id)
            .date(date)
            .student(student)
            .scholarClass(scholarClass)
            .build();
    }
}
