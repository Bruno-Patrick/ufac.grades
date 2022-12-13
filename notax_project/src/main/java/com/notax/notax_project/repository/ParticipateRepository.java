package com.notax.notax_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.model.Participate;

@Repository
public interface ParticipateRepository extends JpaRepository<Participate, Long> {
    
    // Participate findByParticipate_id(long id);
    // List<Participate> findByStudent_idAndDiscipline_id(Long studentId, Long disciplineId);

}
