package com.notax.notax_project.domain.errors;

public class NotFoundException extends Exception {
    public NotFoundException(String field) {
        super(field + "Cannot be null");
    }
}