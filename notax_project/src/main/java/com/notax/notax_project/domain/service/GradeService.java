package com.notax.notax_project.domain.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.GradeDTO;
import com.notax.notax_project.domain.error.NotFoundException;
import com.notax.notax_project.infra.entities.GradeModel;
import com.notax.notax_project.infra.repository.GradeRepository;

@Service
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
            if (grades.size() != 0) {
                return grades.stream().map(
                    model -> modelmapper.map(model, GradeDTO.class)
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(grades.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }        
    }

    @Override
    public GradeDTO getById(Long id) throws Exception {
        try {
            GradeModel grade = repo.findById(id).orElse(null);
            if (Objects.nonNull(grade)) {
                return modelmapper.map(grade, GradeDTO.class);
            } else {
                throw new NotFoundException(id.toString());
            }
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
