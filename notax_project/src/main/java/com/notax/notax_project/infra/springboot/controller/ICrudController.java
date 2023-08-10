package com.notax.notax_project.infra.springboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICrudController<T> {

    public ResponseEntity<List<T>> getAll() throws Exception;
    public ResponseEntity<T> insert() throws Exception;
    public ResponseEntity<T> update() throws Exception;
    public ResponseEntity<T> delete() throws Exception;
}
