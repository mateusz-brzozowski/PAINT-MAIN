package org.example.authorization.controller;

import lombok.RequiredArgsConstructor;
import org.example.authorization.model.LoginRequest;
import org.example.authorization.model.User;
import org.example.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LoginController {
    private final JwtEncoder jwtEncoder;
    private final UserService service;

    @PostMapping
    public Mono<OAuth2Token> login(@RequestBody LoginRequest loginRequest) {
        return service.login(loginRequest)
                .flatMap(this::generateToken);
    }

    private Mono<OAuth2Token> generateToken(User user) {
        var now = Instant.now();
        var expiry = Duration.ofHours(5);

        var claims = JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(now.plus(expiry))
                .subject(String.valueOf(user.getId()))
                .build();

        return Mono.just(claims)
                .map(JwtEncoderParameters::from)
                .mapNotNull(jwtEncoder::encode);
    }
}
