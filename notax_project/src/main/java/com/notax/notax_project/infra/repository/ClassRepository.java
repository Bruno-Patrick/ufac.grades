package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.DisciplineModel;

@Repository
public interface ClassRepository extends JpaRepository<Long, ClassModel>{
    @Query(
        "SELECT c FROM ClassModel c " +
        "WHERE c.classIdent = :ident " +
        "AND c.classIdentOrdinal = :ordinal " +
        "AND c.year = :year"
        )
    List<ClassModel> findByIdentAndOrdinalAndYear(
        @Param("ident") DisciplineModel.Periodicity ident,
        @Param("ordinal") DisciplineModel.Ordinals ordinal,
        @Param("year") Integer year  
        );

    List<ClassModel> findByDiscipline(DisciplineModel discipline);
}
