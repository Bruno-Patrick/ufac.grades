package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.time.LocalDateTime;
import java.util.List;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.domain.entities.User;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.entities.UserModel;
import com.notax.notax_project.infra.springboot.repository.IUserRepository;

public class CreateUserUseCase implements IUseCase<UserDTO, UserDTO> {

    private IUserRepository userRepository;
    private List<IValidator<UserDTO, Exception>> validators;

    public CreateUserUseCase(
        IUserRepository userRepository,
        List<IValidator<UserDTO, Exception>> validators
    ) {
        this.userRepository = userRepository;
        this.validators = validators;
    }

    @Override
    public UserDTO execute(UserDTO userDTO) throws Exception {
        for (IValidator<UserDTO, Exception> validator : validators) {
            validator.validate(userDTO);
        }

        userDTO.setCreateTime(LocalDateTime.now());

        User user = userDTO.toEntity();
        user.setRole(UserModel.ROLES.USER);
        user.setPassword(userDTO.getPassword(), true);
        user.setIsActive(true);

        UserModel userModel = this.userRepository.save(new UserModel(user));

        return new UserDTO(userModel.toEntity());
    }
}
