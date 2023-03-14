package com.example.keycloak.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    private String email;

    private String password;
    @NotNull
    private UserRole userRole;

    private int status;
    private String statusInfo;

}
