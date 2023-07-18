package com.notax.notax_project.infra.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.DisciplineModel;
import com.notax.notax_project.infra.entities.FrequencyModel;
import com.notax.notax_project.infra.entities.StudentModel;

@Repository
public interface FrequencyRepository extends JpaRepository<FrequencyModel, Long> {
    List<FrequencyModel> findByStudentClass(ClassModel studentClass);
    List<FrequencyModel> findByStudentClassAndStudent(
        ClassModel studentClass,
        StudentModel student
    );
    FrequencyModel findByStudentClassAndStudentAndDate(
        ClassModel studentClass,
        StudentModel student,
        Date date
    );
}
