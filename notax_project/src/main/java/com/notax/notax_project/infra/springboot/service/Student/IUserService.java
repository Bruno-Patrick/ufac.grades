package com.notax.notax_project.infra.springboot.service.Student;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.notax.notax_project.application.DTO.UserDTO;

public interface IUserService {
    public UserDTO getByID(Long id, UserDetails user) throws Exception;
    public UserDTO getByEmail(String email, UserDetails auth) throws Exception;
    public List<UserDTO> getAll() throws Exception;
    public UserDTO create(UserDTO userDTO, UserDetails auth) throws Exception;
    public void deleteById(Long id, UserDetails user) throws Exception;
    public UserDTO update(UserDTO userDTO, UserDetails user) throws Exception;
}
