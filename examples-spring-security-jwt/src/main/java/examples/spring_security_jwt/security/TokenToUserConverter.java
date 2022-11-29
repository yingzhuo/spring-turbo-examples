package examples.spring_security_jwt.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.jwt.AbstractJwtTokenToUserConverter;
import spring.turbo.module.security.jwt.AlgorithmFactory;
import spring.turbo.module.security.user.UserDetailsPlus;

import java.util.Optional;

@Component
public class TokenToUserConverter extends AbstractJwtTokenToUserConverter {

    public TokenToUserConverter(AlgorithmFactory algorithmFactory) {
        super(algorithmFactory);
    }

    @Override
    protected Optional<UserDetails> doAuthenticate(String rawToken, DecodedJWT jwt) throws AuthenticationException {
        final UserDetails userDetails =
                UserDetailsPlus.builder()
                        .id(jwt.getClaim("id").asLong())
                        .username(jwt.getClaim("username").asString())
                        .roles(jwt.getClaim("roles").asArray(String.class))
                        .build();

        return Optional.of(userDetails);
    }

}
