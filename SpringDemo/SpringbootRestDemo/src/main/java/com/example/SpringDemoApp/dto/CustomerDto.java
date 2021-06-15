package com.example.SpringDemoApp.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
