package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;

import com.notax.notax_project.infra.shared.validators.IValidator;
import com.notax.notax_project.infra.springboot.controller.useCases.IVoidUseCase;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

public class DeleteUserByEmailUseCase implements IVoidUseCase<String>  {
    private List<IValidator<String, Exception>> validators;
    private UserRepository userRepository;

    public DeleteUserByEmailUseCase(
        UserRepository userRepository,
        List<IValidator<String, Exception>> validators
    ) {
        this.userRepository = userRepository;
        this.validators = validators;
    }

    @Override
    public void execute(String email) throws Exception {

        for (IValidator<String, Exception> validator : validators) {
            validator.validate(email);
        }

        this.userRepository.deleteByEmail(email);
    }
}
