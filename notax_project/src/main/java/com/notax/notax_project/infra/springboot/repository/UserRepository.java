package com.notax.notax_project.infra.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.springboot.entities.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    List<UserModel> findAllByIsActiveTrue();
    long countByIsActiveTrue();
    UserModel findByIdAndIsActiveIsTrue(Long id);
    void deleteByEmail(String email);
}