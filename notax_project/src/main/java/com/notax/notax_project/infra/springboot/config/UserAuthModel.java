package com.notax.notax_project.infra.springboot.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.notax.notax_project.application.DTO.UserDTO;

public class UserAuthModel implements UserDetails {

    private UserDTO userDTO;

    public UserAuthModel(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserAuthModel() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority auth = new SimpleGrantedAuthority(userDTO.getRole().name());
        return Arrays.asList(auth);
    }

    @Override
    public String getPassword() {
        return userDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDTO.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userDTO.getIsActive();
    }

}
