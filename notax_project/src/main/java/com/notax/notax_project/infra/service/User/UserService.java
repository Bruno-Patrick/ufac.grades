package com.notax.notax_project.infra.service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.repository.UserRepository;

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
    public UserDTO getByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'getByEmail'");
    }

    @Override
    public List<UserDTO> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    }
