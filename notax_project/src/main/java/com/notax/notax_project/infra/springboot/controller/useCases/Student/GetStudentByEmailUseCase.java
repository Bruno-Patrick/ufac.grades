package com.notax.notax_project.infra.springboot.controller.useCases.Student;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;

import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.repository.StudentRepository;

public class GetStudentByEmailUseCase implements IUseCase<String, List<StudentDTO>> {

    private StudentRepository studentRepository;
    private List<IValidator<String, Exception>> validators;

    public GetStudentByEmailUseCase(
        StudentRepository studentRepository,
        List<IValidator<String, Exception>> validators
    ) {
        this.studentRepository = studentRepository;
        this.validators = validators;
    }

    @Override
    public List<StudentDTO> execute(String email, UserDetails auth) throws Exception {

        for (IValidator<String, Exception> validator : validators) {
            validator.validate(email);
        }

        return this.studentRepository.findByEmail(email)
        .stream()
            .map(
                model -> new StudentDTO(model.toEntity())
            ).collect(Collectors.toList());
    }

}
