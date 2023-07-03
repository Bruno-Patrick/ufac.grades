package com.notax.notax_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notax.notax_project.DTO.UserDTO;
import com.notax.notax_project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController implements ICrudController<UserDTO> {

    
    private final UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll() throws Exception {
        try {
            List<UserDTO> users = service.getAll();
            return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/byemail/{email}")
    public ResponseEntity<UserDTO> getByEmail(@PathVariable("email") String email) throws Exception {
        try {
            UserDTO user = service.getByEmail(email);
            return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) throws Exception {
        try {
            return new ResponseEntity<UserDTO>(service.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ResponseEntity<UserDTO> insert() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public ResponseEntity<UserDTO> update() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<UserDTO> delete() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    

    
}
