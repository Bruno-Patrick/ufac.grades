package com.notax.notax_project.infra.shared.validators;

import com.notax.notax_project.infra.shared.erros.NullError;

public class NotNullValidator<CustomObject> implements IValidator<CustomObject, Exception> {

    private String entity;

    public NotNullValidator(String entity) {
        this.entity = entity;
    }

    @Override
    public void validate(CustomObject toValidate) throws Exception {
        if (toValidate == null) {
            throw new NullError(this.entity);
        }
    }

}
