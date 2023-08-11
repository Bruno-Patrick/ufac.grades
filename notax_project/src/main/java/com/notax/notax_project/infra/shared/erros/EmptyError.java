package com.notax.notax_project.infra.shared.erros;

public class EmptyError extends Exception {
    public EmptyError(String field) {
        super(field + " cannot be empty!");
    }
}
