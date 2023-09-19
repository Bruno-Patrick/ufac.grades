package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.notax.notax_project.infra.shared.erros.UnauthorizedUserError;
import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IVoidAuthenticationUseCase;
import com.notax.notax_project.infra.springboot.entities.UserModel;
import com.notax.notax_project.infra.springboot.repository.IUserRepository;

public class DeleteUserByIdUseCase implements IVoidAuthenticationUseCase<Long>  {
    private List<IValidator<Long, Exception>> validators;
    private IUserRepository userRepository;

    public DeleteUserByIdUseCase(
        IUserRepository userRepository,
        List<IValidator<Long, Exception>> validators
    ) {
        this.userRepository = userRepository;
        this.validators = validators;
    }

    @Override
    public void execute(Long id, UserDetails user) throws Exception {

        for (IValidator<Long, Exception> validator : validators) {
            validator.validate(id);
        }

        UserModel userModel = this.userRepository.getReferenceById(id);
        if (userModel.equals(user)) {
            this.userRepository.deleteById(id);
        } else {
            throw new UnauthorizedUserError(user.getUsername());
        }
    }
}
