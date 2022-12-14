package com.notax.notax_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.model.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long>{
    
    @Query
    (
        "SELECT d FROM Discipline d " +
        "WHERE disciplineName LIKE %?1% " +
        "OR disciplineYear LIKE %?1% " +
        "OR disciplineSemester LIKE %?1%"
    )
    List<Discipline> findByAll(String searchTerm);
    
    @Query
    (
        "SELECT d FROM Discipline d " +
        "WHERE disciplineName LIKE %?1%"
    )
    List<Discipline> findDisciplineByName(String searchTerm);

    // Discipline findByDiscipline_id(Long id);
    // Discipline findByDiscipline_year(Integer year);
}
