package com.notax.notax_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.model.Responsible;
import com.notax.notax_project.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    @Query
    (
        "SELECT s FROM Student s " +
        "WHERE studentName LIKE %?1% " +
        "OR studentPhone LIKE %?1% " +
        "OR studentRegister LIKE %?1% " +
        "OR studentEmail LIKE %?1%"
    )
    List<Student> findByAll(String searchTerm);

    List<Student> findByStudentResponsible(Responsible responsible);

    
}
