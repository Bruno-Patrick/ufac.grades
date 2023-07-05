package com.notax.notax_project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.notax.notax_project.DTO.DisciplineDTO;
import com.notax.notax_project.domain.entities.DisciplineModel;
import com.notax.notax_project.repository.DisciplineRepository;

public class DisciplineService implements ICrudService<DisciplineDTO> {

    private final DisciplineRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public DisciplineService(DisciplineRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DisciplineDTO> getAll() throws Exception {
        try {
            List<DisciplineModel> disciplines = repo.findAllByIsActiveTrue();
            return disciplines.stream().map(
                model -> modelMapper.map(
                 disciplines,
                 DisciplineDTO.class
                )
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public DisciplineDTO getById(Long id) throws Exception {
        try {
            return modelMapper.map(repo.findById(id), DisciplineDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public DisciplineDTO save(DisciplineDTO object) throws Exception {
        try {
            repo.save(modelMapper.map(object, DisciplineModel.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return object;
    }

    public DisciplineDTO desactivateById(DisciplineDTO object) throws Exception{
        try {
            DisciplineModel discipline = repo.findById(object.id()).orElse(null);
            discipline.setIsActive(false);
            return modelMapper.map(repo.save(discipline), DisciplineDTO.class);
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
