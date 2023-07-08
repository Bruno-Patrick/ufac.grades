package com.notax.notax_project.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.notax.notax_project.application.DTO.PartialDTO;
import com.notax.notax_project.infra.entities.PartialModel;
import com.notax.notax_project.infra.repository.PartialRepository;

public class PartialService implements ICrudService<PartialDTO> {

    private final PartialRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public PartialService(PartialRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PartialDTO> getAll() throws Exception {
        try {
            List<PartialModel> partials = repo.findAll();
            return partials.stream().map(
                model -> modelMapper.map(
                    model,
                    PartialDTO.class
                )
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PartialDTO getById(Long id) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public PartialDTO save(PartialDTO object) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
