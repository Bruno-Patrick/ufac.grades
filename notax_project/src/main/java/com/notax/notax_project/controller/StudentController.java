package com.notax.notax_project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notax.notax_project.model.Student;
import com.notax.notax_project.service.StudentService;

@RestController
@RequestMapping("/aluno")
public class StudentController implements ICrudController<Student> {

    private final StudentService student_service;

    @Autowired
    public StudentController(StudentService student_service)
    {
        this.student_service = student_service;
    }

    @Override
    @GetMapping("/consultar/todos")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> registers = student_service.getAll();
        return new ResponseEntity<>(registers, HttpStatus.OK);
    }

    @Override
    @GetMapping("/consultar/id/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long id) {
        Student registers = student_service.getById(id);
        return new ResponseEntity<>(registers, HttpStatus.OK);
    }

    @Override
    @GetMapping("/consultar/termo/{searchTerm}")
    public ResponseEntity<List<Student>> getByAll(@PathVariable("searchTerm") String searchTerm) {
        List<Student> registers = student_service.getByAll(searchTerm);
        return new ResponseEntity<>(registers, HttpStatus.OK);
    }

    @Override
    @PostMapping("/cadastrar")
    public ResponseEntity<Student> insert(@RequestBody Student objeto) {
        objeto.setStudentAccountCreationTimestamp(new Date());
        objeto.setStudentResponsible(null);
        objeto.setStudentActive(true);
        Student register = student_service.save(objeto);
        return new ResponseEntity<>(register, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/editar")
    public ResponseEntity<Student> update(@RequestBody Student objeto) {
        Student register = student_service.save(objeto);
        return new ResponseEntity<>(register, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Student register = student_service.getById(id);
        
        if (register == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        student_service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
