package com.notax.notax_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.model.DisciplineModel;
import com.notax.notax_project.model.GradeModel;
import com.notax.notax_project.model.PartialModel;
import com.notax.notax_project.model.StudentModel;

@Repository
public interface GradeRepository extends  JpaRepository<GradeModel, Long> {
 
    @Query(
        "SELECT g FROM GradeModel g WHERE g.student = :student "+
        "AND g.discipline = :discipline "+
        "AND g.partial = :partial"
    )
    GradeModel findByStudentAndDisciplineAndPartial(
        @Param("student") StudentModel student,
        @Param("discipline") DisciplineModel discipline,
        @Param("partial") PartialModel partial
    );
}