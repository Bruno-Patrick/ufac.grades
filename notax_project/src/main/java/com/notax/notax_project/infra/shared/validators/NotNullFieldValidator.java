package com.notax.notax_project.infra.shared.validators;

import java.util.Map;

import com.notax.notax_project.application.DTO.IDTO;
import com.notax.notax_project.infra.shared.erros.NullError;

public class NotNullFieldValidator<DTO extends IDTO> implements IValidator<DTO, Exception> {

    private String field;

    public NotNullFieldValidator(String field) {
        this.field = field;
    }

    @Override
    public void validate(DTO toValidate) throws Exception {
        Map<String, Object> mappedDTO = toValidate.toMap();

        if (mappedDTO.get(this.field) == null) {
            throw new NullError(this.field);
        }
    }
}
