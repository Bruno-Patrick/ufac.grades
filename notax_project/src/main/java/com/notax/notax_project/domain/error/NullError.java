package com.notax.notax_project.domain.error;

public class NullError extends Exception {
    public NullError(String field) {
        super(field + " cannot be null");
    }
}
