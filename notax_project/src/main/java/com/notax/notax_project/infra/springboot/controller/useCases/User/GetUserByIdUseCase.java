package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.erros.NotFoundError;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.entities.UserModel;
import com.notax.notax_project.infra.springboot.repository.IUserRepository;

public class GetUserByIdUseCase implements IUseCase<Long, UserDTO> {
    private IUserRepository userRepository;
    private List<IValidator<Long, Exception>> validators;

    public GetUserByIdUseCase(
        IUserRepository userRepository,
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
        UserModel user = this.userRepository.findByIdAndIsActiveIsTrue(id);

        if (user == null) {
            throw new NotFoundError(id.toString());
        }
        return new UserDTO(user.toEntity());
    }

}
