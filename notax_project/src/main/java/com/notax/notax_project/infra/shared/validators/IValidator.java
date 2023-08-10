package com.notax.notax_project.infra.shared.validators;

public interface IValidator<T, CustomException extends Exception> {
    void validate(T toValidate) throws CustomException;
}