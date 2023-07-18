package com.notax.notax_project.domain.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notax.notax_project.application.DTO.DisciplineDTO;
import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.domain.error.NotFoundException;
import com.notax.notax_project.infra.entities.DisciplineModel;
import com.notax.notax_project.infra.entities.StudentModel;
import com.notax.notax_project.infra.repository.DisciplineRepository;

@Service
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
            if (disciplines.size() != 0) {
                return disciplines.stream().map(
                    model -> modelMapper.map(
                     disciplines,
                     DisciplineDTO.class
                    )
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(disciplines.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public DisciplineDTO getById(Long id) throws Exception {
        try {
            DisciplineModel discipline = repo.findById(id).orElse(null);
            if (Objects.nonNull(discipline)) {
                return modelMapper.map(discipline, DisciplineDTO.class);
            } else {
                throw new NotFoundException(discipline.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public DisciplineDTO save(DisciplineDTO object) throws Exception {
        try {
            repo.save(modelMapper.map(object, DisciplineModel.class));
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void changeIsActivate(DisciplineDTO object, Boolean activate) throws Exception{
        try {
            DisciplineModel discipline = repo.findById(object.getId()).orElse(null);
            if (Objects.nonNull(discipline)) {
                discipline.setIsActive(activate);
                repo.save(discipline);
            } else {
                throw new NotFoundException(discipline.toString());
            }
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
