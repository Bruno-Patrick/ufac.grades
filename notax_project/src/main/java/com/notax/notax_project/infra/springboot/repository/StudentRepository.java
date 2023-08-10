package com.notax.notax_project.infra.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    @Query(
        "SELECT s FROM StudentModel " +
        "WHERE s.name LIKE :searchTerm " +
        "OR s.phone LIKE :searchTerm " +
        "OR s.email LIKE :searchTerm"
    )
    List<StudentModel> findBySearchTerm(@Param("searchTerm") String searchTerm);
}
