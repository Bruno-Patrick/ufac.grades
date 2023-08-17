package com.notax.notax_project.infra.springboot.service.Student;

import java.util.List;

import com.notax.notax_project.application.DTO.StudentDTO;

public interface IStudentService {
    StudentDTO create(StudentDTO studentDTO) throws Exception;
    StudentDTO update(StudentDTO studentDTO) throws Exception;
    void deleteById(Long id) throws Exception;
    StudentDTO getById(Long id) throws Exception;
    List<StudentDTO> getByEmail(String email) throws Exception;
}
