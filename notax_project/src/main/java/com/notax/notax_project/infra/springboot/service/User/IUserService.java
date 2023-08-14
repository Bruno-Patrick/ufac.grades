package com.notax.notax_project.infra.springboot.service.User;

import java.util.List;

import com.notax.notax_project.application.DTO.UserDTO;

public interface IUserService {
    public UserDTO getByID(Long id) throws Exception;
    public UserDTO getByEmail(String email) throws Exception;
    public List<UserDTO> getAll() throws Exception;
    public UserDTO create(UserDTO userDTO) throws Exception;
    public List<UserDTO> getBySearchTerm(String searchTerm, Boolean bool) throws Exception;
    public void deleteByEmail(String email) throws Exception;
    public UserDTO update(UserDTO userDTO) throws Exception;
}
