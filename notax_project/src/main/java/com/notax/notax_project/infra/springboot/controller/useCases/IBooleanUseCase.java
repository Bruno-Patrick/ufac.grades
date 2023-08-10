package com.notax.notax_project.infra.springboot.controller.useCases;

public interface IBooleanUseCase<Input, Condition, Output> {
    Output execute(Input input, Condition bool) throws Exception;
}
