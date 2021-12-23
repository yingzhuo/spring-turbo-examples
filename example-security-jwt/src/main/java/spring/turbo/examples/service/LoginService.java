package spring.turbo.examples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.turbo.module.security.jwt.JwtTokenFactory;
import spring.turbo.module.security.jwt.JwtTokenMetadata;

import java.time.Duration;

@Service
public class LoginService {

    @Autowired
    private JwtTokenFactory tokenFactory;

    public String createToken(String username, String password) {
        return tokenFactory.create(
                JwtTokenMetadata.builder()
                        .expiresAtFuture(Duration.ofMinutes(60))
                        .putPayloadClaim("username", username)
                        .build()
        );
    }

}
