package com.notax.notax_project.infra.springboot.service.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.shared.validators.NotEmptyValidator;
import com.notax.notax_project.infra.shared.validators.NotNullFieldValidator;
import com.notax.notax_project.infra.shared.validators.NotNullValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.User.CreateUserUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.GetAllUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.GetUserByEmailUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.GetUserBySearchTermUseCase;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

@Service
public class UserService implements IUserService {

    private CreateUserUseCase createUserUseCase;
    private GetUserByEmailUseCase getUserByEmailUseCase;
    private GetUserBySearchTermUseCase getUserBySearchTermUseCase;
    private GetAllUseCase getAllUseCase;

    public UserService(UserRepository userRepository) {

        List<IValidator<String, Exception>> validators = Stream.of(
            new NotEmptyValidator("email"),
            new NotNullValidator<String>("email")
        ).collect(Collectors.toList());

        this.getUserByEmailUseCase = new GetUserByEmailUseCase(
            userRepository,
            validators
        );

        this.getUserBySearchTermUseCase = new GetUserBySearchTermUseCase(
            userRepository,
            validators
        );

        this.getAllUseCase = new GetAllUseCase(userRepository);

        this.createUserUseCase = new CreateUserUseCase(
            userRepository,
            Stream.of(
                new NotNullFieldValidator<UserDTO>("email"),
                new NotNullFieldValidator<UserDTO>("password"),
                new NotNullFieldValidator<UserDTO>("name"),
                new NotNullFieldValidator<UserDTO>("birthDate")

            ).collect(Collectors.toList())
        );
    }

    @Override
	public List<UserDTO> getAll() {
        return this.getAllUseCase.execute();
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<UserDTO> getBySearchTerm(String searchTerm, Boolean bool) throws Exception {
        return this.getUserBySearchTermUseCase.execute(searchTerm, bool);
    }

    @Override
    public UserDTO getByID(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByID'");
    }

    @Override
    public UserDTO getByEmail(String email) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByEmail'");
    }
}