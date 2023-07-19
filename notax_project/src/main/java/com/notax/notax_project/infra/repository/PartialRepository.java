package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.PartialModel;

@Repository
public interface PartialRepository extends JpaRepository<PartialModel, Long> {
    @Query(
        "SELECT p FROM PartialModel p " +
        "WHERE p.title LIKE :searchTerm " +
        "OR p.description LIKE :searchTerm"
    )
    List<PartialModel> findBySearchTerm(@Param("searchTerm") String searchTerm);
    List<PartialModel> findAllByDiscipline(ClassModel scholarClass);
}
