package com.notax.notax_project.infra.springboot.controller.useCases.User;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.springboot.controller.useCases.IUseCase;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

public class GetUserByEmailUseCase implements IUseCase<String, UserDTO> {

    private UserRepository userRepository;

    @Override
    public UserDTO execute(String email) throws Exception {
        return new UserDTO(this.userRepository.findByEmail(email).toEntity());
    }

}
