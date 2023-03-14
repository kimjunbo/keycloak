package com.example.keycloak.controller;

import com.example.keycloak.DTO.Result;
import com.example.keycloak.DTO.UserDto;
import com.example.keycloak.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
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
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @PostMapping("/signup")
    public ResponseEntity registerUser(@RequestBody UserDto userDto) {
        if(authService.existsByUsername(userDto.getEmail())) {
            return ResponseEntity.ok(new Result(false,"유저가 존재합니다."));
        }
        UserDto result = authService.createUser(userDto);
        return ResponseEntity.ok(new Result(true,result));
    }

    /*
     *  로그인
     * */
//    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody  UserDto userDto) {

        AccessTokenResponse response = authService.setAuth(userDto);
        return ResponseEntity.ok(new Result(true,response));
    }
}