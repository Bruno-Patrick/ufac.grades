package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.DisciplineModel;

@Repository
public interface ClassRepository extends JpaRepository<Long, ClassModel>{
    List<ClassModel> findByDiscipline(DisciplineModel discipline);
}
