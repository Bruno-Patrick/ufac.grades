package com.notax.notax_project.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.model.Partial;

@Repository
public interface PartialRepository extends JpaRepository<Partial, Long>{
    
    @Query
    (
        "SELECT p FROM Partial p " +
        "WHERE partialTitle LIKE %?1% " +
        "OR partialDescription LIKE %?1% " +
        "OR partialIndentifier LIKE %?1%"
    )
    List<Partial> findByAll(String searchTerm);

    // Partial findByPartial_id(Long id);
    // List<Partial> findByDiscipline_id(Long id);
    

}
