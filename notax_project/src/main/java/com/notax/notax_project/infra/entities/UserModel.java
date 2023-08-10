package com.notax.notax_project.infra.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.notax.notax_project.domain.entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserModel implements Serializable {

    public UserModel(User user) {
        setId(user.getId());
        setEmail(user.getEmail());
        setName(user.getName());
        setPhone(user.getPhone());
        setPassword(user.getPassword());
        setCreateTime(user.getCreateTime());
        setIsActive(user.getIsActive());
        setBirthDate(user.getBirthDate());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createTime = LocalDateTime.now();

    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @Column(nullable = false)
    private Date birthDate;

    public User toEntity() {
        return User
            .builder()
            .id(this.id)
            .email(this.email)
            .name(this.name)
            .phone(this.phone)
            .password(this.password)
            .createTime(this.createTime)
            .isActive(this.isActive)
            .birthDate(this.birthDate)
            .build();
    }
}
