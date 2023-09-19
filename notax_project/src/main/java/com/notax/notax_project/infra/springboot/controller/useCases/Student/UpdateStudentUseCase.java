package com.notax.notax_project.infra.springboot.controller.useCases.Student;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.entities.StudentModel;
import com.notax.notax_project.infra.springboot.repository.StudentRepository;

public class UpdateStudentUseCase implements IUseCase<StudentDTO, StudentDTO> {

    private StudentRepository studentRepository;
    private List<IValidator<StudentDTO, Exception>> validators;

    public UpdateStudentUseCase(
        StudentRepository studentRepository,
        List<IValidator<StudentDTO, Exception>> validators
    ) {
        this.studentRepository = studentRepository;
        this.validators = validators;
    }

    @Override
    public StudentDTO execute(StudentDTO studentDTO, UserDetails auth) throws Exception {

        for (IValidator<StudentDTO, Exception> validator : validators) {
            validator.validate(studentDTO);
        }

        return new StudentDTO(
            this.studentRepository.save(
                new StudentModel(
                    studentDTO.toEntity()
                )
            ).toEntity()
        );
    }

}
