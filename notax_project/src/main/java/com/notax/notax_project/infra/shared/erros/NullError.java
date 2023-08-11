package com.notax.notax_project.infra.shared.erros;

public class NullError extends Exception {
    public NullError(String entity) {
        super(entity + " cannot be empty!");
    }
}
