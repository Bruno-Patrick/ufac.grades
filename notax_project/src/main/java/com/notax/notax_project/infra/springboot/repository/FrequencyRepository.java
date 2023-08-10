package com.notax.notax_project.infra.springboot.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.ClassModel;
import com.notax.notax_project.infra.springboot.entities.FrequencyModel;
import com.notax.notax_project.infra.springboot.entities.StudentModel;

@Repository
public interface FrequencyRepository extends JpaRepository<FrequencyModel, Long> {
    List<FrequencyModel> findByScholarClass(ClassModel studentClass);
    List<FrequencyModel> findByScholarClassAndStudent(
        ClassModel scholarClass,
        StudentModel student
    );
    FrequencyModel findByScholarClassAndStudentAndDate(
        ClassModel studentClass,
        StudentModel student,
        Date date
    );
}
