package com.notax.notax_project.infra.shared.erros;

public class UnauthorizedUserError extends Exception {
    public UnauthorizedUserError(String user) {
        super(user + " unauthorized!");
    }
}
