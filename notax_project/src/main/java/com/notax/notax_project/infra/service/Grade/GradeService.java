package com.notax.notax_project.infra.service.Grade;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.ClassDTO;
import com.notax.notax_project.application.DTO.GradeDTO;
import com.notax.notax_project.application.DTO.PartialDTO;
import com.notax.notax_project.application.DTO.StudentDTO;
import com.notax.notax_project.domain.Utils;
import com.notax.notax_project.domain.error.NotFoundException;
import com.notax.notax_project.infra.entities.ClassModel;
import com.notax.notax_project.infra.entities.GradeModel;
import com.notax.notax_project.infra.entities.PartialModel;
import com.notax.notax_project.infra.entities.StudentModel;
import com.notax.notax_project.infra.repository.GradeRepository;

@Service
public class GradeService implements ICrudService<GradeDTO> {

    private final GradeRepository repo;
    private final ModelMapper modelmapper;
    private Utils utils = new Utils();

    @Autowired
    public GradeService(GradeRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelmapper = modelMapper;
    }

    @Override
    public List<GradeDTO> getAll() throws NotFoundException {
        try {
            List<GradeModel> grades = repo.findAll();
            if (grades.size() != 0) {
                return grades.stream().map(
                    model -> modelmapper.map(model, GradeDTO.class)
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(grades.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }        
    }

    public List<GradeDTO> getByStudentAndClass(
        StudentDTO student,
        ClassDTO scholarClass
    ) throws NotFoundException {
        try {
            StudentModel studentModel = modelmapper.map(student,StudentModel.class);
            ClassModel classModel = modelmapper.map(scholarClass,ClassModel.class);

            List<GradeModel> grades = repo.findByStudentAndClass(
                studentModel,
                classModel
            );

            if (grades.size() != 0) {
                return grades.stream().map(
                    model -> modelmapper.map(model, GradeDTO.class)
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(grades.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }        
    }

    public GradeDTO getByStudentAndDisciplineAndPartial(
        StudentDTO student,
        ClassDTO scholarClass,
        PartialDTO partial
    ) throws NotFoundException {
        try {
            StudentModel studentModel = modelmapper.map(student,StudentModel.class);
            ClassModel classModel = modelmapper.map(scholarClass, ClassModel.class);
            PartialModel partialModel = modelmapper.map(partial,PartialModel.class);

            GradeModel grade = repo.findByStudentAndDisciplineAndPartial(
                studentModel,
                classModel,
                partialModel
            );

            if (Objects.nonNull(grade)) {
                return modelmapper.map(grade, GradeDTO.class);
            } else {
                throw new NotFoundException(grade.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } 
    }

    @Override
    public GradeDTO getById(Long id) throws NotFoundException {
        try {
            GradeModel grade = repo.findById(id).orElse(null);
            if (Objects.nonNull(grade)) {
                return utils.converter(grade, GradeDTO.class);
            } else {
                throw new NotFoundException(id.toString(), "not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public GradeDTO save(GradeDTO object) throws NotFoundException {
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
    public void delete(Long id) throws NotFoundException {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
}
