package com.notax.notax_project.infra.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.GuardianModel;

@Repository
public interface GuardianRepository extends JpaRepository<GuardianModel, Long> {

    @Query(
        "SELECT gr FROM GuardianModel gr " +
        "WHERE gr.name LIKE %?1% " +
        "OR gr.phone LIKE %?1% " +
        "OR gr.email LIKE %?1%"
    )
    List<GuardianModel> findBySearchTerm(String searchTerm);
}
