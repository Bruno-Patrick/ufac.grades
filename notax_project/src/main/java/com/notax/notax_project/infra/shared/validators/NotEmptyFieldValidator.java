package com.notax.notax_project.infra.shared.validators;

import com.notax.notax_project.application.DTO.IDTO;

public class NotEmptyFieldValidator<DTO extends IDTO> implements IValidator<DTO, Exception> {

    @Override
    public void validate(DTO toValidate) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }

}
