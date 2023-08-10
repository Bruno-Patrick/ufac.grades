package com.notax.notax_project.infra.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.ClassModel;
import com.notax.notax_project.infra.springboot.entities.DisciplineModel;

@Repository
public interface ClassRepository extends JpaRepository<Long, ClassModel>{
    List<ClassModel> findByDiscipline(DisciplineModel discipline);
}
