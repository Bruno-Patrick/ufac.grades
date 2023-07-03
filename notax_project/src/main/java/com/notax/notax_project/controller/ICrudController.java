package com.notax.notax_project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICrudController<T> {
    
    public ResponseEntity<List<T>> getAll();
    public ResponseEntity<T> getById();
    public ResponseEntity<T> insert();
    public ResponseEntity<T> update();
    public ResponseEntity<T> delete();
}
