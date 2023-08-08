package com.notax.notax_project.domain.entities;

import java.util.List;

import com.notax.notax_project.domain.error.NullError;
import com.notax.notax_project.infra.entities.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guardian {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private List<StudentModel> studentsList;

    public void setId(Long id) throws NullError {
        if (id == null) {
            throw new NullError("id");
        }
        this.id = id;
    }
    public void setName(String name) throws NullError {
        if (name == null) {
            throw new NullError("name");
        }
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setStudentsList(List<StudentModel> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Guardian other = (Guardian) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
