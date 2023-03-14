package com.example.keycloak.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum UserRole {

    ADMIN("관리자"),
    USER("사용자");


    private final String title;

    public static UserRole of(String title) {
        return Arrays.stream(values())
                .filter(v -> v.getTitle().equals(title))
                .findFirst().orElseThrow(() -> new ExpressionException(title));
    }

    public String getCode() {
        return name();
    }
}