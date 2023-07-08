package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notax.notax_project.infra.entities.DisciplineModel;
import com.notax.notax_project.infra.entities.PartialModel;

public interface PartialRepository extends JpaRepository<PartialModel, Long> {
    List<PartialModel> findAllByDiscipline(DisciplineModel discipline);
}
