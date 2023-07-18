package com.notax.notax_project.application.DTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("phone")
    String phone;
    @JsonProperty("is_active")
    Boolean isActive;
    @JsonProperty("birth_date")
    Date birthDate;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(this.id.toString(), this.id);
        map.put(this.email.toString(), this.email);
        map.put(this.password.toString(), this.password);
        map.put(this.createTime.toString(), this.createTime);
        map.put(this.firstName.toString(), this.firstName);
        map.put(this.lastName.toString(), this.lastName);
        map.put(this.phone.toString(), this.phone);
        map.put(this.isActive.toString(), this.isActive);
        map.put(this.birthDate.toString(), this.birthDate);
        return map;
    }
}
