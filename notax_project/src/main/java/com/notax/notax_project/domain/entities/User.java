package com.notax.notax_project.domain.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.notax.notax_project.domain.error.NotEmptyError;
import com.notax.notax_project.domain.error.NullError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String email;
    private String name;
    private String phone;
    private String password;
    private LocalDateTime createTime;
    @Builder.Default private Boolean isActive = true;
    private Date birthDate;

    public void setId(Long id) {
        this.id = id;
    }
    public void setEmail(String email) throws NullError, NotEmptyError{
        if (email == null) {
            throw new NullError("email");
        }
        if (email.length() == 0) {
            throw new NotEmptyError("email");
        }
        this.email = email;
    }
    public void setName(String name) throws NullError, NotEmptyError {
        if (name == null) {
            throw new NullError("name");
        }
        if (name.length() == 0) {
            throw new NotEmptyError("name");
        }
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPassword(String password) throws NullError, NotEmptyError {
        setPassword(password, false);
    }
    public void setPassword(String password, boolean encrypt) throws NullError, NotEmptyError {
        if (password == null) {
            throw new NullError("password");
        }
        if (password.length() == 0) {
            throw new NotEmptyError("password");
        }
        if (encrypt) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            password = encoder.encode(password);
        }
        this.password = password;
    }
    public void setCreateTime(LocalDateTime createTime) throws NullError {
        if(Objects.isNull(createTime)) {
            throw new NullError("createTime");
        }
        this.createTime = createTime;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public void setBirthDate(Date birthDate) throws NullError {
        if (Objects.isNull(birthDate)) {
            throw new NullError("email");
        }
        this.birthDate = birthDate;
    }
}
