package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.DisciplineModel;
import com.notax.notax_project.infra.entities.PartialModel;

@Repository
public interface PartialRepository extends JpaRepository<PartialModel, Long> {
    List<PartialModel> findAllByDiscipline(DisciplineModel discipline);
}
