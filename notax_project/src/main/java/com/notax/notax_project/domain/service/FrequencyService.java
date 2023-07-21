package com.notax.notax_project.domain.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.ClassDTO;
import com.notax.notax_project.application.DTO.FrequencyDTO;
import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.domain.Utils;
import com.notax.notax_project.domain.error.NotFoundException;
import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.FrequencyModel;
import com.notax.notax_project.infra.entities.StudentModel;
import com.notax.notax_project.infra.repository.FrequencyRepository;

@Service
public class FrequencyService implements ICrudService<FrequencyDTO> {

    private final FrequencyRepository repo;
    private final ModelMapper modelMapper;
    private Utils utils = new Utils();

    @Autowired
    public FrequencyService(FrequencyRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FrequencyDTO> getAll() throws Exception {
        try {
            List<FrequencyModel> frequencies = repo.findAll();
            if (frequencies.size() != 0) {
                return frequencies.stream().map(
                    model -> modelMapper.map(
                        model,
                        FrequencyDTO.class
                    )
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(frequencies.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<FrequencyDTO> getByScholarClass(ClassDTO studentClass) throws Exception {
        try {
            ClassModel classModel = utils.converter(studentClass, ClassModel.class);
            List<FrequencyModel> frequencies = repo.findByScholarClass(classModel);
            if (frequencies.size() != 0) {
                return frequencies.stream().map(
                    model -> modelMapper.map(
                        model,FrequencyDTO.class)
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(frequencies.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<FrequencyDTO> getByScholarClassAndStudent(
        ClassModel studentClass,
        StudentDTO student
        ) throws Exception {
        try {
            List<FrequencyModel> frequencies = repo.findByScholarClassAndStudent(
                modelMapper.map(studentClass,ClassModel.class),
                modelMapper.map(student,StudentModel.class)
            );
            if (frequencies.size() != 0) {
                return frequencies.stream().map(
                    model -> modelMapper.map(
                        model,FrequencyDTO.class)
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(frequencies.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public FrequencyDTO getByScholarAndStudentAndDate(
        ClassModel studentClass,
        StudentDTO student,
        Date date
        ) throws Exception {
        try {
            FrequencyModel frequency = repo.findByScholarClassAndStudentAndDate(
                modelMapper.map(studentClass,ClassModel.class),
                modelMapper.map(student,StudentModel.class),
                date
            );
            if (Objects.nonNull(frequency)) {
                return modelMapper.map(
                    frequency,
                    FrequencyDTO.class
                );
            } else {
                throw new NotFoundException(frequency.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FrequencyDTO getById(Long id) throws Exception {
        try {
            FrequencyModel frequency = repo.findById(id).orElse(null);
            if (Objects.nonNull(frequency)) {
                return modelMapper.map(
                    frequency,
                    FrequencyDTO.class
                );
            } else {
                throw new NotFoundException(frequency.toString(), "not found");
            }
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
