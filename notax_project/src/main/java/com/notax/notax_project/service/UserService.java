package com.notax.notax_project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notax.notax_project.DTO.UserDTO;
import com.notax.notax_project.domain.entities.UserModel;
import com.notax.notax_project.repository.UserRepository;

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
            return userList.stream()
                    .map(model -> modelMapper.map(
                            userList,
                            UserDTO.class
                        )
                    ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public UserDTO getByEmail(String email) throws Exception {
        try {
            return modelMapper.map(
                repo.findByEmailAndIsActiveTrue(email),
                UserDTO.class
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<UserDTO> getAllByFirstNameAndLastName(String firtName, String lastName) throws Exception {
        try {
            List<UserModel> users = repo.findAllByFirstNameAndLastNameAndIsActiveTrue(firtName, lastName);
            return users.stream().map(user -> modelMapper.map(
                                        users,
                                        UserDTO.class
                                     )
            ).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public UserDTO getById(Long id) throws Exception {
        try {
            return modelMapper.map(repo.findById(id).orElse(null), UserDTO.class);
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

    public void desativateById(Long id) throws Exception {
        try {
            UserModel user = repo.findById(id).orElse(null);
            user.setIsActive(false);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void activeById(Long id) throws Exception {
        try {
            UserModel user = repo.findById(id).orElse(null);
            user.setIsActive(true);
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
