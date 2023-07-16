package com.notax.notax_project.domain.error;

public class NotFoundException extends Exception {
    public NotFoundException(String field) {
        super(field + "Not found");
    }
}