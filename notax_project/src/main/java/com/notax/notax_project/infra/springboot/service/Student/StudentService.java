package com.notax.notax_project.infra.springboot.service.Student;

import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.StudentDTO;

@Service
public class StudentService implements IStudentService {

    @Override
    public StudentDTO create(StudentDTO studentDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public StudentDTO getById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public StudentDTO getByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'getByEmail'");
    }

}
