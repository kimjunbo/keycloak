package com.example.keycloak;

import org.keycloak.OAuth2Constants;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {
    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;


    /*
     *  keycloak.json 대신에 Spring Boot yml 파일을 이용하도록 돕는다.
     * */
    @Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(authServerUrl)
                .realm(realm)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
        //      .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();

//     아이디/ 패스워드로 keycloak 접속 인증
//     KeycloakBuilder.builder()
//        .serverUrl(authServerUrl)
//        .realm(realm)
//        .clientId(clientId)
//        .grantType(OAuth2Constants.PASSWORD)
//        .clientSecret(clientSecret)
//        .username(username)
//        .password(password)
//        .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()).build();
    }
}
