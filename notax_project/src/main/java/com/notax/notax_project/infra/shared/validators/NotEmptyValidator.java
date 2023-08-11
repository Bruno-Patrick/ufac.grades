package com.notax.notax_project.infra.shared.validators;

import com.notax.notax_project.infra.shared.erros.EmptyError;

public class NotEmptyValidator implements IValidator<String, EmptyError> {

    private String field;

    public NotEmptyValidator(String entity) {
        this.field = entity;
    }

    @Override
    public void validate(String toValidate) throws EmptyError {
        if (toValidate != null && toValidate.isEmpty()) {
            throw new EmptyError(this.field);
        }
    }
}
