package com.notax.notax_project.domain.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.notax.notax_project.application.DTO.DisciplineDTO;
import com.notax.notax_project.application.DTO.FrequencyDTO;
import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.infra.entities.DisciplineModel;
import com.notax.notax_project.infra.entities.FrequencyModel;
import com.notax.notax_project.infra.entities.StudentModel;
import com.notax.notax_project.infra.repository.FrequencyRepository;

public class FrequencyService implements ICrudService<FrequencyDTO> {

    private final FrequencyRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public FrequencyService(FrequencyRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FrequencyDTO> getAll() throws Exception {
        try {
            List<FrequencyModel> frequencies = repo.findAll();
            return frequencies.stream().map(
                model -> modelMapper.map(
                    model,
                    FrequencyDTO.class
                )
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<FrequencyDTO> getByDiscipline(DisciplineDTO discipline) {
        try {
            List<FrequencyModel> frequencies = repo.findByDiscipline(
                modelMapper.map(discipline,DisciplineModel.class)
            );
            return frequencies.stream().map(
                model -> modelMapper.map(
                    model,FrequencyDTO.class)
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<FrequencyDTO> getByDisciplineAndStudent(
        DisciplineDTO discipline,
        StudentDTO student
        ) {
        try {
            List<FrequencyModel> frequencies = repo.findByDisciplineAndStudent(
                modelMapper.map(discipline,DisciplineModel.class),
                modelMapper.map(student,StudentModel.class)
            );
            return frequencies.stream().map(
                model -> modelMapper.map(
                    model,FrequencyDTO.class)
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public FrequencyDTO getByDisciplineAndStudentAndDate(
        DisciplineDTO discipline,
        StudentDTO student,
        Date date
        ) {
        try {
            FrequencyModel frequencie = repo.findByDisciplineAndStudentAndDate(
                modelMapper.map(discipline,DisciplineModel.class),
                modelMapper.map(student,StudentModel.class),
                date
            );
            return modelMapper.map(
                frequencie,
                FrequencyDTO.class
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FrequencyDTO getById(Long id) throws Exception {
        try {
            return modelMapper.map(
                repo.findById(id),
                FrequencyDTO.class
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FrequencyDTO save(FrequencyDTO object) throws Exception {
        try {
            repo.save(
                modelMapper.map(
                    object,
                    FrequencyModel.class
                )
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
