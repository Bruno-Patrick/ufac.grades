package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;
import java.util.stream.Collectors;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.springboot.controller.useCases.IOutputUseCase;
import com.notax.notax_project.infra.springboot.repository.IUserRepository;

public class GetAllUseCase implements IOutputUseCase<List<UserDTO>> {

    private IUserRepository userRepository;

    public GetAllUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> execute() {
        return this.userRepository.findAll().stream()
            .filter(
                model -> model != null
            )
            .map(
                model -> new UserDTO(model.toEntity())
            ).collect(Collectors.toList());
    }
}
