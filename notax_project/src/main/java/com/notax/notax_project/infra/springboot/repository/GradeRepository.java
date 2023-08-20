package com.notax.notax_project.infra.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.GradeModel;
import com.notax.notax_project.infra.springboot.entities.PartialModel;
import com.notax.notax_project.infra.springboot.entities.StudentModel;

@Repository
public interface GradeRepository extends  JpaRepository<GradeModel, Long> {

    List<GradeModel> findByStudentAndPartial(
        StudentModel student,
        PartialModel partial
    );
}