package com.notax.notax_project.infra.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.infra.shared.erros.NotFoundError;
import com.notax.notax_project.infra.springboot.service.User.UserService;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthModel userAuthModel = new UserAuthModel();

        try {
            UserDTO userDTO = userService.getByEmail(username);

            if (userDTO == null) {
                throw new NotFoundError(username);
            }

            userAuthModel = new UserAuthModel(userDTO);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userAuthModel;
    }
}
