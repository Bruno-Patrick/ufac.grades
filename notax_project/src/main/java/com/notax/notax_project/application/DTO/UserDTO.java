package com.notax.notax_project.application.DTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.notax.notax_project.domain.entities.User;

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
public class UserDTO {
    @JsonProperty("id")
    Long id;
    @JsonProperty("email")
    String email;
    @JsonProperty(access = Access.WRITE_ONLY)
    String password;
    @JsonProperty("create_time")
    LocalDateTime createTime;
    @JsonProperty("name")
    String name;
    @JsonProperty("phone")
    String phone;
    @JsonProperty("is_active")
    Boolean isActive;
    @JsonProperty("birth_date")
    Date birthDate;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("email", this.email);
        map.put("password", this.password);
        map.put("createTime", this.createTime);
        map.put("name", this.name);
        map.put("phone", this.phone);
        map.put("isActive", this.isActive);
        map.put("birthDate", this.birthDate);
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
            .build();
    }
}
