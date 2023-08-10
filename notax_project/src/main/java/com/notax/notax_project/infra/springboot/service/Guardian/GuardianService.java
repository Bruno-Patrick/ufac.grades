package com.notax.notax_project.infra.springboot.service.Guardian;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.GuardianDTO;
import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.domain.error.NotFoundException;
import com.notax.notax_project.infra.springboot.entities.GuardianModel;
import com.notax.notax_project.infra.springboot.entities.StudentModel;
import com.notax.notax_project.infra.springboot.repository.GuardianRepository;

import jakarta.transaction.Transactional;

@Service
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
            if (guardians.size() != 0) {
                return guardians.stream().map(
                    model -> modelMapper.map(
                        model,
                        GuardianDTO.class)
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(guardians.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<GuardianDTO> getBySeatchTerm(String searchTerm) throws Exception {
        try {
            List<GuardianModel> guardians = repo.findBySearchTerm(searchTerm);
            if (guardians.size() != 0) {
                return guardians.stream().map(
                    model -> modelMapper.map(
                        model,
                        GuardianDTO.class)
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(guardians.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public List<StudentDTO> getStudentsOfGuard(Long id) throws Exception {
        try {
            GuardianModel guardian = repo.findById(id).orElse(null);
            List<StudentModel> students = guardian.getStudentsList();
            if (students.size() != 0) {
                return students.stream().map(
                    model -> modelMapper.map(
                        model,
                        StudentDTO.class)
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(students.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public GuardianDTO getById(Long id) throws Exception {
        try {
            GuardianModel guardian = repo.findById(id).orElse(null);
            if (Objects.nonNull(guardian)) {
                return modelMapper.map(guardian, GuardianDTO.class);
            } else {
                throw new NotFoundException(id.toString(), "not found");
            }
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
