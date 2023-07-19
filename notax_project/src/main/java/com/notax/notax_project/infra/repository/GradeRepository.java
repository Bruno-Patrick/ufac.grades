package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.GradeModel;
import com.notax.notax_project.infra.entities.PartialModel;
import com.notax.notax_project.infra.entities.StudentModel;

@Repository
public interface GradeRepository extends  JpaRepository<GradeModel, Long> {
 
    @Query(
        "SELECT g FROM GradeModel g " +
        "WHERE g.student = :student " +
        "AND g.scholarClass = :scholarClass "+
        "AND g.partial = :partial"
    )
    GradeModel findByStudentAndDisciplineAndPartial(
        @Param("student") StudentModel student,
        @Param("discipline") ClassModel scholarClass,
        @Param("partial") PartialModel partial
    );

    List<GradeModel> findByStudentAndScholarClass(
        StudentModel student,
        ClassModel scholarClass
    );
}