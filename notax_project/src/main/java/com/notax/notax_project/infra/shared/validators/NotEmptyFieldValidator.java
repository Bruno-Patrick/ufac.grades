package com.notax.notax_project.infra.shared.validators;

import java.util.Map;

import com.notax.notax_project.application.DTO.IDTO;
import com.notax.notax_project.infra.shared.erros.EmptyError;

public class NotEmptyFieldValidator<DTO extends IDTO> implements IValidator<DTO, Exception> {

    private String field;

    public NotEmptyFieldValidator(String field) {
        this.field = field;
    }

    @Override
    public void validate(DTO toValidate) throws Exception {
        Map<String, Object> mappedDTO = toValidate.toMap();

        if (mappedDTO.get(this.field).toString().isEmpty()) {
            throw new EmptyError(this.field);
        }
    }
}
