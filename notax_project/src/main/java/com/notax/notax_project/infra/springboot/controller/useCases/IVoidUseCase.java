package com.notax.notax_project.infra.springboot.controller.useCases;

public interface IVoidUseCase<Input> {
    public void execute(Input input) throws Exception;
}
