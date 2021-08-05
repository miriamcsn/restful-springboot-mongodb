package com.myfactory.restfulspringbootmongodb.dto;

import com.myfactory.restfulspringbootmongodb.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String name, email;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
