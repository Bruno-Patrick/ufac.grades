package com.notax.notax_project.infra.springboot.controller.api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.erros.EntityAlreadyExists;
import com.notax.notax_project.infra.shared.erros.NotFoundError;
import com.notax.notax_project.infra.shared.erros.UnauthorizedUserError;
import com.notax.notax_project.infra.springboot.config.UserAuthModel;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserAuthModel) authentication.getPrincipal();

        try {
            UserDTO mDTO = userService.create(userDTO, user);
            return new ResponseEntity<UserDTO>(mDTO,HttpStatus.CREATED);
        } catch (EntityAlreadyExists e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable("id") Long id) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserAuthModel) authentication.getPrincipal();

        try {
            userService.deleteById(id, user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnauthorizedUserError e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    @PutMapping()
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserAuthModel) authentication.getPrincipal();

        UserDTO mDTO = userService.update(userDTO, user);
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserAuthModel) authentication.getPrincipal();

        try {
            UserDTO userDTO = userService.getByEmail(email, user);
            return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
        } catch (NotFoundError e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserAuthModel) authentication.getPrincipal();

        try {
            UserDTO userDTO = userService.getByID(id, user);
            return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
        } catch (NotFoundError e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
