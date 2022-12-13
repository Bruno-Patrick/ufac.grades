package com.notax.notax_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.model.Grades;
import com.notax.notax_project.model.Partial;
import com.notax.notax_project.model.Student;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Long>{
 
    // Grades findByGrades_id(Long id);
    // List<Grades> findByStudent_id(Student student_id);
    // List<Grades> findByPartial_id(Partial partial_id);
    // List<Grades> findByStudent_idAndPartial_id(Student student_id, Partial partial_id);

}
