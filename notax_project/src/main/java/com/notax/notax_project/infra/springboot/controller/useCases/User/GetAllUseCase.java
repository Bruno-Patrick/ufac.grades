package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;
import java.util.stream.Collectors;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.springboot.controller.useCases.IOutputUseCase;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

public class GetAllUseCase implements IOutputUseCase<List<UserDTO>> {

    private UserRepository userRepository;

    public GetAllUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> execute() {
        return this.userRepository.findAll().stream()
            .map(
                userModel -> new UserDTO(userModel.toEntity())
            ).collect(Collectors.toList());
    }
}
