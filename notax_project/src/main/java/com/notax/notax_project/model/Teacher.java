package com.notax.notax_project.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Teacher implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long teacherId;

    @Column(nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private String teacherPhone;

    @Column(nullable = false, unique = true)
    private String teacherEmail;

    @Column(nullable = false, unique = true)
    private String teacherUsername;

    @Column(nullable = false)
    private String teacherPassword;

    @Column(nullable = false)
    private Eroles teacherRole;

    @Column(nullable = false)
    private Date teacherBirthdate;

    public void setTeacherPassoword(String password)
    {
        setTeacherPassoword(password, true);
    }

    public void setTeacherPassoword(String password, boolean encript) 
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        if (encript) 
        {
            password = passwordEncoder.encode(password);
        }
        this.teacherPassword = password;
    }

}
