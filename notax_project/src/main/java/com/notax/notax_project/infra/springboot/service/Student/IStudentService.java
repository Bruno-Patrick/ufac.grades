package com.notax.notax_project.infra.springboot.service.Student;

import com.notax.notax_project.application.DTO.StudentDTO;

public interface IStudentService {
    StudentDTO create(StudentDTO studentDTO);
    StudentDTO update(StudentDTO studentDTO);
    void deleteById(Long id);
    StudentDTO getById(Long id);
    StudentDTO getByEmail(String email);
}
