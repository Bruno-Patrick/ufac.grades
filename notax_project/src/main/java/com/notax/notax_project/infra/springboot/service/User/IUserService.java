package com.notax.notax_project.infra.springboot.service.User;

import java.util.List;

import com.notax.notax_project.application.DTO.UserDTO;

public interface IUserService {
    public UserDTO getByID(Long id);
    public UserDTO getByEmail(String email);
    public List<UserDTO> getAll();
}
