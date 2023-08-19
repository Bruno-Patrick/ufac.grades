package com.notax.notax_project.application.DTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.notax.notax_project.domain.entities.User;
import com.notax.notax_project.infra.springboot.entities.UserModel;

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
public class UserDTO implements IDTO {
    @JsonProperty(namespace = "id", access = Access.READ_ONLY)
    Long id;
    @JsonProperty("email")
    String email;
    @JsonProperty(access = Access.WRITE_ONLY)
    String password;
    @JsonProperty(namespace = "create time", access = Access.READ_ONLY)
    LocalDateTime createTime;
    @JsonProperty("name")
    String name;
    @JsonProperty("phone")
    String phone;
    @JsonProperty("active")
    Boolean isActive;
    @JsonProperty("birth date")
    Date birthDate;
    @JsonProperty(namespace = "role", access = Access.READ_ONLY)
    UserModel.ROLES role;

    public UserDTO(User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setCreateTime(user.getCreateTime());
        this.setName(user.getName());
        this.setPhone(user.getPhone());
        this.setIsActive(user.getIsActive());
        this.setBirthDate(user.getBirthDate());
        this.setRole(user.getRole());;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("email", this.email);
        map.put("password", this.password);
        map.put("createTime", this.createTime);
        map.put("name", this.name);
        map.put("phone", this.phone);
        map.put("isActive", this.isActive);
        map.put("birthDate", this.birthDate);
        map.put("role", this.role);
        return map;
    }

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
                .role(this.role)
                .build();
    }
}
