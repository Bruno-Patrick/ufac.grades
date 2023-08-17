package com.notax.notax_project.infra.springboot.controller.useCases.Student;

import java.util.List;

import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.repository.StudentRepository;

public class GetStudentByIdUseCase implements IUseCase<Long, StudentDTO> {

    private StudentRepository studentRepository;
    private List<IValidator<Long, Exception>> validators;

    public GetStudentByIdUseCase(
        StudentRepository studentRepository,
        List<IValidator<Long, Exception>> validators
    ) {
        this.studentRepository = studentRepository;
        this.validators = validators;
    }

    @Override
    public StudentDTO execute(Long id) throws Exception {

        for (IValidator<Long, Exception> validator : validators) {
            validator.validate(id);
        }

        return new StudentDTO(
            this.studentRepository.findById(id).orElse(null).toEntity()
        );
    }
}
