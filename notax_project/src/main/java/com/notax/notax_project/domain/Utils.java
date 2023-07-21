package com.notax.notax_project.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class Utils {
    private ModelMapper mapper = new ModelMapper();

    /**
     * This function must be able to converter
     * class to other class (MODEL to DTO)
     * @param <T> if T be a Model, D will be a DTO
     * @param <D> if T br a DTO, D will be a Model
     * @param source must be source class (for example: StudentModel)
     * @param target must be target.class (for example: StudentDTO.class)
     * @return will be a object of target class type
     */
    public <T, D> D converter(T source, Class<D> target) {
        return mapper.map(source, target);
    }

    /**
     * This function must be able to converter a list of objects
     * in other list of other type object (for exmaple: List of Model to List of DTO)
     * @param <T> if T be a Model, D will be a DTO
     * @param <D> if T br a DTO, D will be a Model
     * @param source must be source class (for example: List of StudentModel)
     * @param target must be target.class (for example: StudentDTO.class)
     * @return will be a List of target class type object
     */
    public <T, D> List<D> converterListOfObjects(List<T> source, Class<D> target) {
        return source.stream().map(
            model -> mapper.map(
                model,
                target
            )
        ).collect(Collectors.toList());
    }
}
