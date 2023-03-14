package com.example.keycloak.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private String username;

    private String password;
    @NotNull
    private String userRole;

    private int status;
    private String statusInfo;

    private String daum_thumbnail;
    private String kakaotalk_thumbnail;

}
