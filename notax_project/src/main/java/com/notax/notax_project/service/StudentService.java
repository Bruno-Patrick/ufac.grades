package com.notax.notax_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.notax.notax_project.model.Student;
import com.notax.notax_project.repository.StudentRepository;

@Service
public class StudentService implements ICrudService<Student>{

    private final StudentRepository student_repo;

    @Autowired
    public StudentService(StudentRepository student_repo) {
        this.student_repo = student_repo;
    }

    @Override
    public List<Student> getAll() {
        List<Student> registers = student_repo.findAll();
        return registers;
    }

    @Override
    public Student getById(Long id) {
        Student register = student_repo.findById(id).orElse(null);
        return register;
    }

    // Caso for aplicar paginação, finalizar essa função
    @Override
    public Page<List<Student>> getByAll(String searchTerm, int page, int size) {
        return null;
    }

    public List<Student> getByAll(String searchTerm) {
        List<Student> registers = student_repo.findByAll(searchTerm);
        return registers;
    }

    @Override
    public Student save(Student objeto) {
        if (objeto != null) 
        {
            return student_repo.save(objeto);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        student_repo.deleteById(id);
    }
    
}
