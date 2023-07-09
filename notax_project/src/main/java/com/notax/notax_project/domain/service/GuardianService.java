package com.notax.notax_project.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.notax.notax_project.application.DTO.GuardianDTO;
import com.notax.notax_project.infra.entities.GuardianModel;
import com.notax.notax_project.infra.repository.GuardianRepository;

public class GuardianService implements ICrudService<GuardianDTO> {

    private final GuardianRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public GuardianService(
        GuardianRepository repo,
        ModelMapper modelMapper
    ) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GuardianDTO> getAll() throws Exception {
        try {
            List<GuardianModel> guardians = repo.findAll();
            return guardians.stream().map(
                model -> modelMapper.map(
                    model,
                    GuardianDTO.class)
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public GuardianDTO getById(Long id) throws Exception {
        try {
            return modelMapper.map(repo.findById(id), GuardianDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public GuardianDTO save(GuardianDTO object) throws Exception {
        try {
            repo.save(
                modelMapper.map(object, GuardianModel.class)
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
