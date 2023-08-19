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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notax.notax_project.application.DTO.UserDTO;
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
    public ResponseEntity<UserDTO> create(UserDTO userDTO) throws Exception {
        UserDTO mDTO = userService.create(userDTO);
        return new ResponseEntity<UserDTO>(mDTO,HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping()
    public ResponseEntity<UserDTO> delete(String email) throws Exception {
        userService.deleteByEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping()
    public ResponseEntity<UserDTO> update(UserDTO userDTO) throws Exception {
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
        UserDTO userDTO = userService.getByEmail(email);
        return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) throws Exception {
        UserDTO userDTO = userService.getByID(id);
        return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
    }

    // @Override
    // @GetMapping("/{searchTerm}")
    // public ResponseEntity<List<UserDTO>> getBySearchTerm(
    //     @PathVariable("searchTerm") String searchTerm
    // ) throws Exception {
    //     List<UserDTO> userDTOs  = userService.getBySearchTerm(searchTerm,true);
    //     return new ResponseEntity<List<UserDTO>>(userDTOs,HttpStatus.OK);
    // }

}
