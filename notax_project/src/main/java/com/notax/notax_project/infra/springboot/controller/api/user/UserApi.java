package com.notax.notax_project.infra.springboot.controller.api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.erros.NotFoundError;
import com.notax.notax_project.infra.springboot.service.User.UserService;

@RestController
@RequestMapping("/user")
public class UserApi implements IUserApi {

    @Autowired UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping()
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println(userDTO.getEmail());
        System.out.println(userDTO.getName());
        System.out.println(userDTO.getPassword());
        System.out.println(userDTO.getPhone());
        UserDTO mDTO = userService.create(userDTO);
        return new ResponseEntity<UserDTO>(mDTO,HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{email}")
    public ResponseEntity<UserDTO> delete(@PathVariable("email") String email) throws Exception {
        userService.deleteByEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping()
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) throws Exception {
        UserDTO mDTO = userService.update(userDTO);
        return new ResponseEntity<UserDTO>(mDTO, HttpStatus.OK);
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAll() throws Exception {
        List<UserDTO> userDTOs = userService.getAll();
        return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
    }

    @Override
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getByEmail(@PathVariable("email") String email) throws Exception {
        try {
            UserDTO userDTO = userService.getByEmail(email);
            return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
        } catch (NotFoundError e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) throws Exception {
        try {
            UserDTO userDTO = userService.getByID(id);
            return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
        } catch (NotFoundError e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
