package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.erros.NotFoundError;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.entities.UserModel;
import com.notax.notax_project.infra.springboot.repository.IUserRepository;

public class GetUserByEmailUseCase implements IUseCase<String, UserDTO> {

    private IUserRepository userRepository;
    private List<IValidator<String, Exception>> validators;

    public GetUserByEmailUseCase(
        IUserRepository userRepository,
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
        UserModel user = this.userRepository.findByEmail(email);

        if (user == null) {
            throw new NotFoundError(email);
        }
        return new UserDTO(user.toEntity());
    }
}
