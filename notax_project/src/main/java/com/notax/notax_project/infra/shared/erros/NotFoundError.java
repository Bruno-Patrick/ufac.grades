package com.notax.notax_project.infra.shared.erros;

public class NotFoundError extends Exception {
    public NotFoundError(String field) {
        super("Not found " + field);
    }
}
