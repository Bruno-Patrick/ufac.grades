package com.notax.notax_project.infra.springboot.service.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.springboot.repository.UserRepository;

@Service
public class UserService implements IUserService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDTO getByID(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getByID'");
    }

    @Override
    public UserDTO getByEmail(String email) throws Exception {
        return this.getUserByEmailUseCase.execute(email);
    }

    @Override
    public List<UserDTO> getAll() {
        return this.getAllUseCase.execute();
    }

    }
