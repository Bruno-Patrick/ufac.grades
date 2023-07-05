package com.notax.notax_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notax.notax_project.domain.entities.DisciplineModel;
import com.notax.notax_project.domain.entities.PartialModel;

public interface PartialRepository extends JpaRepository<PartialModel, Long> {
    List<PartialModel> findAllByDiscipline(DisciplineModel discipline);
}
