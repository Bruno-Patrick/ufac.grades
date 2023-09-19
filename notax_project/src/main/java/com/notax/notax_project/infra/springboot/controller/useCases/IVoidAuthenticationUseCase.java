package com.notax.notax_project.infra.springboot.controller.useCases;

import org.springframework.security.core.userdetails.UserDetails;

public interface IVoidAuthenticationUseCase<Input> {
    public void execute(Input input, UserDetails user) throws Exception;
}
