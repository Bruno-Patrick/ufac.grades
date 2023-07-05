package com.notax.notax_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.domain.entities.DisciplineModel;
import com.notax.notax_project.domain.entities.UserModel;

@Repository
public interface DisciplineRepository extends JpaRepository<DisciplineModel, Long> {
    DisciplineModel findByUser(UserModel user);
    List<DisciplineModel> findAllByIsActiveTrue();
}
