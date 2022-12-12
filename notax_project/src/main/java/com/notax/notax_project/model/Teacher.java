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
    private Long teacher_id;

    @Column(nullable = false)
    private String teacher_name;

    @Column(nullable = false)
    private String teacher_phone;

    @Column(nullable = false, unique = true)
    private String teacher_email;

    @Column(nullable = false, unique = true)
    private String teacher_username;

    @Column(nullable = false)
    private String teacher_password;

    @Column(nullable = false)
    private Eroles teacher_role;

    @Column(nullable = false)
    private Date teacher_birthdate;

    public void setTeacher_passoword(String password)
    {
        setTeacher_passoword(password, true);
    }

    public void setTeacher_passoword(String password, boolean encript) 
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        if (encript) 
        {
            password = passwordEncoder.encode(password);
        }
        this.teacher_password = password;
    }

}
