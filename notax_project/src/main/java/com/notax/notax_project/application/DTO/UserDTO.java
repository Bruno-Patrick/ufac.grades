package com.notax.notax_project.application.DTO;

import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    Long id;
    String email;
    @JsonProperty(access = Access.WRITE_ONLY)
    String password;
    @JsonProperty("create_time")
    long createTime;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
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
        map.put("createTime", this.createTime);
        map.put(this.firstName.toString(), this.firstName);
        map.put(this.lastName.toString(), this.lastName);
        map.put(this.phone.toString(), this.phone);
        map.put(this.isActive.toString(), this.isActive);
        map.put(this.birthDate.toString(), this.birthDate);
        return map;
    }
}