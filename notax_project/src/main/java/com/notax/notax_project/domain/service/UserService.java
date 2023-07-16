package com.notax.notax_project.domain.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notax.notax_project.application.DTO.UserDTO;
import com.notax.notax_project.domain.error.NotFoundException;
import com.notax.notax_project.infra.entities.UserModel;
import com.notax.notax_project.infra.repository.UserRepository;

@Service
public class UserService implements ICrudService<UserDTO> {

    private final UserRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> getAll() throws Exception {
        try {
            List<UserModel> userList = repo.findAllByIsActiveTrue();
            if (userList.size() != 0) {
                return userList.stream()
                        .map(model -> modelMapper.map(
                                model,
                                UserDTO.class
                            )
                        ).collect(Collectors.toList());
                } else {
                    throw new NotFoundException("Users");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public UserDTO getByEmail(String email) throws Exception {
        try {
            UserModel user = repo.findByEmailAndIsActiveTrue(email);
            if (Objects.nonNull(user)) {
                return modelMapper.map(
                    user,
                    UserDTO.class
                );
            } else {
                throw new NotFoundException(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<UserDTO> getAllByFirstNameAndLastName(String firtName, String lastName) throws Exception {
        try {
            List<UserModel> users = repo.findAllByFirstNameAndLastNameAndIsActiveTrue(firtName, lastName);
            if (users.size() != 0) {
                return users.stream().map(user -> modelMapper.map(
                        user,
                        UserDTO.class
                    )
                ).collect(Collectors.toList());
            } else {
                throw new NotFoundException(firtName + " " + lastName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public UserDTO getById(Long id) throws Exception {
        try {
            UserModel user = repo.findById(id).orElse(null);
            if (Objects.nonNull(user)) {
                return modelMapper.map(user, UserDTO.class);
            } else {
                throw new NotFoundException(id.toString());
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

    public void changeIsActiveById(Long id, Boolean activate) throws Exception {
        try {
            UserModel user = repo.findById(id).orElse(null);
            if (Objects.nonNull(user)) {
                user.setIsActive(activate);
                repo.save(user);
            } else {
                throw new NotFoundException(id.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public UserDTO save(UserDTO object) throws Exception {
        try {
           repo.save(modelMapper.map(object, UserModel.class));
           return object;
       } catch (Exception e) {
        e.printStackTrace();
        throw e;
       }
    }
    
}
