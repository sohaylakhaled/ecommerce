package com.example.demo.dto;

import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

public class CustomerDto {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private Integer id;
    private String name;

    private String Email;

}
