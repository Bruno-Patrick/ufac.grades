package com.notax.notax_project.domain.service;

import java.util.List;

public interface ICrudService<T> {
    
    public List<T> getAll() throws Exception;

    public T getById(Long id) throws Exception;

    public T save(T object) throws Exception;

    public void delete(Long id) throws Exception;

}
