package com.notax.notax_project.infra.springboot.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.notax.notax_project.infra.springboot.entities.UserModel;

public class UserAuthModel implements UserDetails {

    private UserModel userModel;

    public UserAuthModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public UserAuthModel() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority auth = new SimpleGrantedAuthority(userModel.getRole().name());
        return Arrays.asList(auth);
    }

    @Override
    public String getPassword() {
        return userModel.getPassword();
    }

    @Override
    public String getUsername() {
        return userModel.getEmail();
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
        return userModel.getIsActive();
    }

}
