package com.notax.notax_project.infra.service.Partial;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.PartialDTO;
import com.notax.notax_project.domain.error.NotFoundException;
import com.notax.notax_project.infra.entities.PartialModel;
import com.notax.notax_project.infra.repository.PartialRepository;

@Service
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
            if (partials.size() != 0) {
                return partials.stream().map(
                    model -> modelMapper.map(
                        model,
                        PartialDTO.class
                    )
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(partials.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    List<PartialDTO> findBySearchTerm(String searchTerm) throws Exception {
        try {
            List<PartialModel> partials = repo.findBySearchTerm(searchTerm);
            if (partials.size() != 0) {
                return partials.stream().map(
                    model -> modelMapper.map(
                        model,
                        PartialDTO.class
                    )
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(partials.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PartialDTO getById(Long id) throws Exception {
        try {
            PartialModel partial = repo.findById(id).orElse(null);
            if (Objects.nonNull(partial)) {
                return modelMapper.map(
                    partial,
                    PartialDTO.class
                );
            } else {
                throw new NotFoundException(id.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PartialDTO save(PartialDTO object) throws Exception {
        try {
            repo.save(modelMapper.map(
                object,
                PartialModel.class
            ));
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
