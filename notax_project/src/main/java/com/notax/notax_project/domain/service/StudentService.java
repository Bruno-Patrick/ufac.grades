package com.notax.notax_project.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notax.notax_project.application.DTO.DisciplineDTO;
import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.infra.entities.DisciplineModel;
import com.notax.notax_project.infra.entities.StudentModel;
import com.notax.notax_project.infra.repository.StudentRepository;

@Service
public class StudentService implements ICrudService<StudentDTO> {

    private final StudentRepository repo;
    private final ModelMapper modelmapper;

    @Autowired
    public StudentService(StudentRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelmapper = modelMapper;
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
        try {
            List<StudentModel> students = repo.findAll();
            return students.stream().map(
                model -> modelmapper.map(model, StudentDTO.class)
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentDTO getById(Long id) throws Exception {
        try {
            return modelmapper.map(
                repo.findById(id).orElse(null),
                StudentDTO.class
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public List<DisciplineDTO> getDisciplinesByStudentId(Long id) throws Exception {
        try {
            List<DisciplineModel> disciplines = repo.findById(id).orElse(null).getDisciplinesList();
            return disciplines.stream().map(
                model -> modelmapper.map(model, DisciplineDTO.class)
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentDTO save(StudentDTO object) throws Exception {
        try {
            repo.save(modelmapper.map(object,StudentModel.class));
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
}
