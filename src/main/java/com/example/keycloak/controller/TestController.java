package com.example.keycloak.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/permitAll")
    public ResponseEntity<String> permitAll() {
        return ResponseEntity.ok("누구나 접근이 가능합니다.\n");
    }

    @GetMapping("/authenticated")
    public ResponseEntity<String> authenticated(@RequestHeader String Authorization) {
//    public ResponseEntity<String> authenticated(@RequestHeader String Authorization) {
//        log.debug(Authorization);
        return ResponseEntity.ok("로그인한 사람 누구나 가능합니다.\n");
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> user(@RequestHeader String Authorization) {
        return ResponseEntity.ok("user 가능합니다.\n");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> admin(@RequestHeader String Authorization) {
//    public ResponseEntity<String> admin(@RequestHeader String Authorization) {
//        log.debug(Authorization);
        return ResponseEntity.ok("admin 가능합니다.\n");
    }

}
