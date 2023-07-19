package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.DisciplineModel;
import com.notax.notax_project.infra.entities.UserModel;

@Repository
public interface DisciplineRepository extends JpaRepository<DisciplineModel, Long> {
    @Query(
        "SELECT d FROM DisciplineModel d " +
        "WHERE d.name LIKE :searchTerm " +
        "OR d.organization LIKE :searchTerm " +
        "AND d.isActive = :bool"
    )
    List<DisciplineModel> findBySearchTerm(
        @Param("searchTerm") String searchTerm,
        @Param("isActive") Boolean bool
    );

    @Query(
        "SELECT c FROM DisciplineModel d " +
        "LEFT JOIN classList c" +
        "ON :id = c.id " +
        "AND c.isActive = :isActive"
    )
    List<ClassModel> findAllClassesByDiscipline(
        @Param("id") Long id,
        @Param("isActive") Boolean bool
    );
    
    DisciplineModel findByUserAndIsActiveTrue(UserModel user);
    List<DisciplineModel> findAllByIsActiveTrue();
    
}
