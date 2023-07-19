package com.notax.notax_project.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notax.notax_project.infra.entities.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query(
        "SELECT u FROM UserModel " +
        "WHERE u.name LIKE :searchTerm " +
        "OR u.email LIKE :searchTerm " +
        "OR u.phone LIKE :searchTerm " +
        "AND u.isActive = 1"
    )
    List<UserModel> findBySearchTerm(@Param("searchTerm") String seacrhTerm);
    UserModel findByEmail(String email);
    List<UserModel> findAllByIsActiveTrue();
    long countByIsActiveTrue();
}