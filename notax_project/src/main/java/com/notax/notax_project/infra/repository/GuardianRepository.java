package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.GuardianModel;

@Repository
public interface GuardianRepository extends JpaRepository<GuardianModel, Long> {
    
    @Query(
        "SELECT gr FROM GuardianModel gr " +
        "WHERE gr.name LIKE :searchTerm " +
        "OR gr.phone LIKE :searchTerm " +
        "OR gr.email LIKE :searchTerm"
    )
    List<GuardianModel> findBySearchTerm(@Param("searchTerm") String searchTerm);
}
