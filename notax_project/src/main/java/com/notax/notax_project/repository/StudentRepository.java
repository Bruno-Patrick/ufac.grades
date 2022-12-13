package com.notax.notax_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.model.Responsible;
import com.notax.notax_project.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // @Query
    // (
    //     "SELECT s FROM Student " +
    //     "WHERE student_name LIKE %?1% " +
    //     "OR student_phone LIKE %?1% " +
    //     "OR student_register LIKE %?1%" +
    //     "OR student_email LIKE %?1%"
    // )
    // List<Student> findByAll(String searchTerm);

    // List<Student> findByStudent_responsible(Responsible responsible);
    // Student findById(Long id);

}
