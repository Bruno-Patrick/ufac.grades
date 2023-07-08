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

    @Transactional
    public List<StudentDTO> getAllStudentsByDisciplineId(Long id) throws Exception {
        try {
            List<StudentModel> students = repo.findById(id).orElse(null).getStudentsList();
            return students.stream().map(
                model -> modelMapper.map(model, StudentDTO.class)
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
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void changeIsActivate(DisciplineDTO object, Boolean activate) throws Exception{
        try {
            DisciplineModel discipline = repo.findById(object.id()).orElse(null);
            discipline.setIsActive(activate);
            repo.save(discipline);
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
