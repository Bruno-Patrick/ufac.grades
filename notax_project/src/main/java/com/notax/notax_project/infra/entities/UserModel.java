package com.notax.notax_project.infra.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.notax.notax_project.application.DTO.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private final long createTime = new Date().getTime();

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column(nullable = false)
    private Date birthDate;

    public void setPassword(String password) {
        setPassword(password, false);
    }

    public void setPassword(String password, boolean encrypt) {
        if (encrypt) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            password = encoder.encode(password);
        }
        this.password = password;
    }
}
