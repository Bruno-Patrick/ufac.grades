package com.notax.notax_project.domain.error;

public class NotEmptyError extends Exception {
    public NotEmptyError(String field) {
        super(field + " cannot be empty");
    }
}
