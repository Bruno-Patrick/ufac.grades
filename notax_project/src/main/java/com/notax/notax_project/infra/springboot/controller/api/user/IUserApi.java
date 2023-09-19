package com.notax.notax_project.infra.springboot.controller.api.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.notax.notax_project.application.DTO.UserDTO;

public interface IUserApi {
    ResponseEntity<UserDTO> create(UserDTO userDTO) throws Exception;
    ResponseEntity<UserDTO> delete(Long id) throws Exception;
    ResponseEntity<List<UserDTO>> getAll() throws Exception;
    ResponseEntity<UserDTO> getByEmail(String email) throws Exception;
    ResponseEntity<UserDTO> getById(Long id) throws Exception;
    ResponseEntity<UserDTO> update(UserDTO userDTO) throws Exception;
}
