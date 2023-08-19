package com.notax.notax_project.infra.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.ClassModel;
import com.notax.notax_project.infra.springboot.entities.PartialModel;

@Repository
public interface PartialRepository extends JpaRepository<PartialModel, Long> {
    @Query(
        "SELECT p FROM PartialModel p " +
        "WHERE p.title LIKE %?1% " +
        "OR p.description LIKE %?1%"
    )
    List<PartialModel> findBySearchTerm(String searchTerm);
    List<PartialModel> findAllByScholarClass(ClassModel scholarClass);
}
