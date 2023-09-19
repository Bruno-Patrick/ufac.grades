package com.notax.notax_project.infra.springboot.controller.useCases;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUseCase<Input, Output> {
    Output execute(Input input, UserDetails auth) throws Exception;
}
