package com.notax.notax_project.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ICrudService<T> {
    
    public List<T> getAll();

    public T getById(Long id);

    public Page<List<T>> getByAll(String searchTerm, int page, int size);

    public T save(T objeto);

    public void delete(Long id);

}
