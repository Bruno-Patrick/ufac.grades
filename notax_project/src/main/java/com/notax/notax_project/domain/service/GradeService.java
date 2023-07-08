package com.notax.notax_project.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.notax.notax_project.application.DTO.GradeDTO;
import com.notax.notax_project.infra.entities.GradeModel;
import com.notax.notax_project.infra.repository.GradeRepository;

public class GradeService implements ICrudService<GradeDTO> {

    private final GradeRepository repo;
    private final ModelMapper modelmapper;

    @Autowired
    public GradeService(GradeRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelmapper = modelMapper;
    }

    @Override
    public List<GradeDTO> getAll() throws Exception {
        try {
            List<GradeModel> grades = repo.findAll();
            return grades.stream().map(
                model -> modelmapper.map(model, GradeDTO.class)
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }        
    }

    @Override
    public GradeDTO getById(Long id) throws Exception {
        try {
            return modelmapper.map(repo.findById(id), GradeDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public GradeDTO save(GradeDTO object) throws Exception {
        try {
            repo.save(
                modelmapper.map(object, GradeModel.class)
            );
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
