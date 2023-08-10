package com.notax.notax_project.infra.springboot.controller.useCases;

public interface IUseCase<Input, Output> {
    Output execute(Input input) throws Exception;
}
