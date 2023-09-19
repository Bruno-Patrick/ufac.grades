package com.notax.notax_project.infra.springboot.service.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.shared.validators.NotEmptyFieldValidator;
import com.notax.notax_project.infra.shared.validators.NotEmptyValidator;
import com.notax.notax_project.infra.shared.validators.NotNullFieldValidator;
import com.notax.notax_project.infra.shared.validators.NotNullValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.Student.CreateStudentUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.Student.DeleteStudentByIdUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.Student.GetStudentByEmailUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.Student.GetStudentByIdUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.Student.UpdateStudentUseCase;
import com.notax.notax_project.infra.springboot.repository.StudentRepository;

@Service
public class StudentService implements IStudentService {

    private CreateStudentUseCase createStudentUseCase;
    private UpdateStudentUseCase updateStudentUseCase;
    private DeleteStudentByIdUseCase deleteStudentByIdUseCase;
    private GetStudentByIdUseCase getStudentByIdUseCase;
    private GetStudentByEmailUseCase getStudentByEmailUseCase;

    public StudentService(StudentRepository studentRepository) {

        List<IValidator<StudentDTO, Exception>> validators = Stream.of(
            new NotNullFieldValidator<StudentDTO>("id"),
            new NotNullFieldValidator<StudentDTO>("name"),
            new NotEmptyFieldValidator<StudentDTO>("id"),
            new NotEmptyFieldValidator<StudentDTO>("name")
        ).collect(Collectors.toList());

        this.createStudentUseCase = new CreateStudentUseCase(studentRepository,validators);

        this.updateStudentUseCase = new UpdateStudentUseCase(studentRepository, validators);

        this.deleteStudentByIdUseCase = new DeleteStudentByIdUseCase(
            studentRepository,
            Stream.of(
               new NotNullValidator<Long>("id")
            ).collect(Collectors.toList())
        );

        this.getStudentByIdUseCase = new GetStudentByIdUseCase(
            studentRepository,
            Stream.of(
               new NotNullValidator<Long>("id")
            ).collect(Collectors.toList())
        );

        this.getStudentByEmailUseCase = new GetStudentByEmailUseCase(
            studentRepository,
            Stream.of(
                new NotEmptyValidator("email"),
                new NotNullValidator<String>("email")
            ).collect(Collectors.toList())
        );
    }

    @Override
    public StudentDTO create(StudentDTO studentDTO, UserDetails auth) throws Exception {
        return this.createStudentUseCase.execute(studentDTO, auth);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO, UserDetails auth) throws Exception {
        return this.updateStudentUseCase.execute(studentDTO, auth);
    }

    @Override
    public void deleteById(Long id, UserDetails auth) throws Exception {
        this.deleteStudentByIdUseCase.execute(id, auth);
    }

    @Override
    public StudentDTO getById(Long id, UserDetails auth) throws Exception {
        return this.getStudentByIdUseCase.execute(id, auth);
    }

    @Override
    public List<StudentDTO> getByEmail(String email, UserDetails auth) throws Exception {
        return this.getStudentByEmailUseCase.execute(email, auth);
    }

}
