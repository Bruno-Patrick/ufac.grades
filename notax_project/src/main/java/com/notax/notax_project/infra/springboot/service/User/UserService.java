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
import com.notax.notax_project.infra.springboot.controller.useCases.User.DeleteUserByEmailUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.GetAllUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.GetUserByEmailUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.GetUserByIdUseCase;
// import com.notax.notax_project.infra.springboot.controller.useCases.User.GetUserBySearchTermUseCase;
import com.notax.notax_project.infra.springboot.controller.useCases.User.UpdateUserUseCase;
import com.notax.notax_project.infra.springboot.repository.IUserRepository;

@Service
public class UserService implements IUserService {

    private CreateUserUseCase createUserUseCase;
    private GetUserByEmailUseCase getUserByEmailUseCase;
    private GetAllUseCase getAllUseCase;
    private GetUserByIdUseCase getUserByIdUseCase;
    private DeleteUserByEmailUseCase deleteUserByEmailUseCase;
    private UpdateUserUseCase updateUserUseCase;

    public UserService(IUserRepository IUserRepository) {

        List<IValidator<String, Exception>> validators = Stream.of(
            new NotEmptyValidator("email"),
            new NotNullValidator<String>("email")
        ).collect(Collectors.toList());

        this.getUserByEmailUseCase = new GetUserByEmailUseCase(
            IUserRepository,
            validators
        );

        this.getAllUseCase = new GetAllUseCase(IUserRepository);

        this.createUserUseCase = new CreateUserUseCase(
            IUserRepository,
            Stream.of(
                new NotNullFieldValidator<UserDTO>("email"),
                new NotNullFieldValidator<UserDTO>("password"),
                new NotNullFieldValidator<UserDTO>("name"),
                new NotNullFieldValidator<UserDTO>("birthDate")
            ).collect(Collectors.toList())
        );

        this.getUserByIdUseCase = new GetUserByIdUseCase(
            IUserRepository,
            Stream.of(
                new NotNullValidator<Long>("id")
            ).collect(Collectors.toList())
        );

        this.deleteUserByEmailUseCase = new DeleteUserByEmailUseCase(
            IUserRepository,
            Stream.of(
                new NotEmptyValidator("email"),
                new NotNullValidator<String>("email")
            ).collect(Collectors.toList())
        );

        this.updateUserUseCase = new UpdateUserUseCase(
            IUserRepository,
            Stream.of(
                new NotNullFieldValidator<UserDTO>("name"),
                new NotNullValidator<UserDTO>("id"),
                new NotNullValidator<UserDTO>("password"),
                new NotNullValidator<UserDTO>("name"),
                new NotNullValidator<UserDTO>("birthDate"),
                new NotNullValidator<UserDTO>("createTime"),
                new NotNullValidator<UserDTO>("isActive"),
                new NotNullValidator<UserDTO>("birthDate")
            ).collect(Collectors.toList())
        );
    }


    @Override
    public UserDTO create(UserDTO userDTO) throws Exception {
        return this.createUserUseCase.execute(userDTO);
    }

    @Override
    public void deleteByEmail(String email) throws Exception {
        this.deleteUserByEmailUseCase.execute(email);;
    }

    @Override
    public UserDTO update(UserDTO userDTO) throws Exception {
        return this.updateUserUseCase.execute(userDTO);
    }

    @Override
    public UserDTO getByID(Long id) throws Exception {
        return this.getUserByIdUseCase.execute(id);
    }

    @Override
    public UserDTO getByEmail(String email) throws Exception {
        return this.getUserByEmailUseCase.execute(email);
    }

    @Override
    public List<UserDTO> getAll() {
        return this.getAllUseCase.execute();
    }
}