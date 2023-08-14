package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.entities.UserModel;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

public class UpdateUserUseCase implements IUseCase<UserDTO, UserDTO> {

    private UserRepository userRepository;
    private List<IValidator<UserDTO, Exception>> validators;

    public UpdateUserUseCase(
        UserRepository userRepository,
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
        return new UserDTO(this.userRepository.save(new UserModel(userDTO.toEntity())).toEntity());
    }

}
