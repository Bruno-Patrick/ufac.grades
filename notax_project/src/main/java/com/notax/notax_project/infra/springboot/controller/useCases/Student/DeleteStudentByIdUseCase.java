package com.notax.notax_project.infra.springboot.controller.useCases.Student;

import java.util.List;

import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IVoidUseCase;
import com.notax.notax_project.infra.springboot.repository.StudentRepository;

public class DeleteStudentByIdUseCase implements IVoidUseCase<Long> {

    private StudentRepository studentRepository;
    private List<IValidator<Long, Exception>> validators;

    public DeleteStudentByIdUseCase(
        StudentRepository studentRepository,
        List<IValidator<Long, Exception>> validators
    ) {
        this.studentRepository = studentRepository;
        this.validators = validators;
    }

    @Override
    public void execute(Long id) throws Exception {

        for (IValidator<Long, Exception> validator : validators) {
            validator.validate(id);
        }

        this.studentRepository.deleteById(id);
    }

}
