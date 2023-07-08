package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.GuardianModel;
import com.notax.notax_project.infra.entities.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    List<StudentRepository> findAllByGuardiansList(GuardianModel guardians);
}
