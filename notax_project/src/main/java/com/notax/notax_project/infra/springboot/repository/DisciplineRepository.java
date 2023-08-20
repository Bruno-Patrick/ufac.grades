package com.notax.notax_project.infra.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.ClassModel;
import com.notax.notax_project.infra.springboot.entities.DisciplineModel;
import com.notax.notax_project.infra.springboot.entities.UserModel;

@Repository
public interface DisciplineRepository extends JpaRepository<DisciplineModel, Long> {
    DisciplineModel findByUserAndIsActiveTrue(UserModel user);
    List<DisciplineModel> findByClassList(ClassModel classModel);
    List<DisciplineModel> findAllByIsActiveTrue();

}
