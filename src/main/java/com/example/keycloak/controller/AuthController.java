package com.example.keycloak.controller;

import com.example.keycloak.DTO.Result;
import com.example.keycloak.DTO.UserDto;
import com.example.keycloak.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;

    /*
     * 회원가입
     * */
    @PostMapping("/signup")
    public ResponseEntity registerUser(@RequestBody UserDto userDto) {
        if(authService.existsByUsername(userDto.getUsername())) {
            return ResponseEntity.ok(new Result(false,"유저가 존재합니다."));
        }
        return ResponseEntity.ok(new Result(true,authService.createUser(userDto)));
    }

    /*
     *  로그인
     * */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody  UserDto userDto) {

        AccessTokenResponse response = authService.setAuth(userDto);
        return ResponseEntity.ok(new Result(true,response));
    }

    @GetMapping("/userinfo")
    public ResponseEntity userInfoController() {
        return ResponseEntity.ok(new Result(true,authService.userInfo()));
    }

}