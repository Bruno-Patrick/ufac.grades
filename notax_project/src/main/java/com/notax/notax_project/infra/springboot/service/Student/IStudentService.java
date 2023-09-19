package com.notax.notax_project.infra.springboot.service.Student;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.notax.notax_project.application.DTO.StudentDTO;

public interface IStudentService {
    StudentDTO create(StudentDTO studentDTO, UserDetails auth) throws Exception;
    StudentDTO update(StudentDTO studentDTO, UserDetails auth) throws Exception;
    void deleteById(Long id, UserDetails auth) throws Exception;
    StudentDTO getById(Long id, UserDetails auth) throws Exception;
    List<StudentDTO> getByEmail(String email, UserDetails auth) throws Exception;
}
