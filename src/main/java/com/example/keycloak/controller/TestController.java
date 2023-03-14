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
        return ResponseEntity.ok("로그인한 사람 누구나 가능합니다.\n");
    }

    @PreAuthorize("hasAnyRole('daum_user')")
    @GetMapping("/daum_user")
    public ResponseEntity<String> daum_user(@RequestHeader String Authorization) {
        return ResponseEntity.ok("daum user 가능합니다.\n");
    }

    @PreAuthorize("hasAnyRole('daum_admin')")
    @GetMapping("/daum_admin")
    public ResponseEntity<String> daum_admin(@RequestHeader String Authorization) {
        return ResponseEntity.ok("daum admin 가능합니다.\n");
    }

    @PreAuthorize("hasAnyRole('kakaotalk_user')")
    @GetMapping("/kakaotalk_user")
    public ResponseEntity<String> kakaotalk_user(@RequestHeader String Authorization) {
        return ResponseEntity.ok("kakaotalk_user 가능합니다.\n");
    }

    @PreAuthorize("hasAnyRole('kakaotalk_admin')")
    @GetMapping("/kakaotalk_admin")
    public ResponseEntity<String> kakaotalk_admin(@RequestHeader String Authorization) {
        return ResponseEntity.ok("kakaotalk_admin 가능합니다.\n");
    }

}
