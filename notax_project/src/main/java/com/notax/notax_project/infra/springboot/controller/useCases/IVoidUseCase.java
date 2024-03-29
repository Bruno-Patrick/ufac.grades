package com.notax.notax_project.infra.springboot.controller.useCases;

import org.springframework.security.core.userdetails.UserDetails;

public interface IVoidUseCase<Input> {
    public void execute(Input input, UserDetails auth) throws Exception;
}
