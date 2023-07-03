package com.notax.notax_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.model.DisciplineModel;
import com.notax.notax_project.model.UserModel;

@Repository
public interface DisciplineRepository extends JpaRepository<DisciplineModel, Long> {
    DisciplineModel findByUser(UserModel user);
}
