package com.notax.notax_project.infra.springboot.controller.useCases.User;

import java.util.List;
import java.util.stream.Collectors;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.springboot.controller.useCases.IBooleanUseCase;
import com.notax.notax_project.infra.springboot.entities.UserModel;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

public class GetUserBySearchTermUseCase implements IBooleanUseCase<String, Boolean, List<UserDTO>> {

    private UserRepository userRepository;

    @Override
    public List<UserDTO> execute(String input, Boolean bool) throws Exception {
        List<UserModel> data = this.userRepository.findBySearchTerm(input, bool);
        return data.stream()
            .map(
                model -> new UserDTO(model.toEntity())
            ).collect(Collectors.toList()
        );
    }

}
