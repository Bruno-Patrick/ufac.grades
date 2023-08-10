package com.notax.notax_project.infra.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.ClassModel;
import com.notax.notax_project.infra.springboot.entities.GradeModel;
import com.notax.notax_project.infra.springboot.entities.PartialModel;
import com.notax.notax_project.infra.springboot.entities.StudentModel;

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

    List<GradeModel> findByStudentAndClass(
        StudentModel student,
        ClassModel scholarClass
    );
}