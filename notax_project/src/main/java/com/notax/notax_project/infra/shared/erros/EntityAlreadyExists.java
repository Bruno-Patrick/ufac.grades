package com.notax.notax_project.infra.shared.erros;

public class EntityAlreadyExists extends Exception {
    public EntityAlreadyExists(String field, String value) {
        super("Entity with " + field + " " + value + " already exists");
    }
}
