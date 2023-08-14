package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

public class GetUserByIdUseCase implements IUseCase<Long, UserDTO> {
    private UserRepository userRepository;
    private List<IValidator<Long, Exception>> validators;

    public GetUserByIdUseCase(
        UserRepository userRepository,
        List<IValidator<Long, Exception>> validators
    ) {
        this.userRepository = userRepository;
        this.validators = validators;
    }

    @Override
    public UserDTO execute(Long id) throws Exception {

        for (IValidator<Long, Exception> validator : validators) {
            validator.validate(id);
        }
        return new UserDTO(this.userRepository.findByIdAndIsActiveIsTrue(id).toEntity());
    }

}
