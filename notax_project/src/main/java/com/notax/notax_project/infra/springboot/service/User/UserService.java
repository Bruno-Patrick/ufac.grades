package com.notax.notax_project.infra.springboot.service.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.shared.validators.NotEmptyValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.User.CreateUserUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.GetUserByEmailUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.GetUserBySearchTermUseCase;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private GetUserByEmailUseCase getUserByEmailUseCase;
    private CreateUserUseCase createUserUseCase;
    private GetUserBySearchTermUseCase getUserBySearchTermUseCase;

    public UserService(UserRepository userRepository) {
       this.userRepository = userRepository;

        List<IValidator<String, Exception>> validators = Stream.of(
            new NotEmptyValidator("emaiil")
        ).collect(Collectors.toList());

    }

    @Override
    public UserDTO getByID(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getByID'");
    }

    @Override
    public UserDTO getByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'getByEmail'");
    }

    @Override
    public List<UserDTO> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
}
