package spring.turbo.examples.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.filter.TokenAuthenticationFilter;
import spring.turbo.module.security.filter.TokenAuthenticationFilterFactory;
import spring.turbo.module.security.jwt.AbstractJwtTokenToUserConverter;
import spring.turbo.module.security.jwt.AlgorithmFactory;
import spring.turbo.module.security.user.UserDetailsPlus;
import spring.turbo.util.RandomStringUtils;
import spring.turbo.webmvc.function.RequestPredicateFactories;
import spring.turbo.webmvc.token.TokenResolver;

import java.util.Optional;

@Component
class JwtAuthFilterFactory implements TokenAuthenticationFilterFactory {

    private final AlgorithmFactory algorithmFactory;
    private final TokenResolver tokenResolver;

    public JwtAuthFilterFactory(AlgorithmFactory algorithmFactory, TokenResolver tokenResolver) {
        this.algorithmFactory = algorithmFactory;
        this.tokenResolver = tokenResolver;
    }

    @Override
    public TokenAuthenticationFilter create() {
        TokenAuthenticationFilter filter = new TokenAuthenticationFilter();
        filter.setTokenResolver(tokenResolver);
        filter.setTokenToAuthenticationConverter(new JwtTokenToUserConverter(algorithmFactory));
        filter.addSkipPredicates(RequestPredicateFactories.pathAntStyleMatches("/**/security/login"));
        return filter;
    }

    private static class JwtTokenToUserConverter extends AbstractJwtTokenToUserConverter {

        public JwtTokenToUserConverter(AlgorithmFactory algorithmFactory) {
            super(algorithmFactory);
        }

        @Override
        protected Optional<UserDetails> doAuthenticate(String rawToken, DecodedJWT jwt) throws AuthenticationException {
            final UserDetails userDetails = UserDetailsPlus.builder()
                    .username(jwt.getClaim("username").asString())
                    .password(RandomStringUtils.random(32))
                    .authorities("ROLE_USER")
                    .build();
            return Optional.of(userDetails);
        }
    }

}
