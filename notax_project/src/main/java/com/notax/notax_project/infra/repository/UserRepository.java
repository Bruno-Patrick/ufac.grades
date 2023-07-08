package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmailAndIsActiveTrue(String email);
    List<UserModel> findAllByFirstNameAndLastNameAndIsActiveTrue(String firstName, String lastName);
    List<UserModel> findAllByIsActiveTrue();
    long countByIsActiveTrue();
}
