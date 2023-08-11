package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

public class GetUserByEmailUseCase implements IUseCase<String, UserDTO> {

    private UserRepository userRepository;
    private List<IValidator<String, Exception>> validators;

    public GetUserByEmailUseCase(
        UserRepository userRepository,
        List<IValidator<String, Exception>> validators
    ) {
        this.userRepository = userRepository;
        this.validators = validators;
    }

    @Override
    public UserDTO execute(String email) throws Exception {

        for (IValidator<String, Exception> validator : validators) {
            validator.validate(email);
        }
        return new UserDTO(this.userRepository.findByEmail(email).toEntity());
    }
}
