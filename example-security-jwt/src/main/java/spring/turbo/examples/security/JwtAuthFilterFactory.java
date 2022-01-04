package spring.turbo.examples.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.filter.TokenAuthenticationFilter;
import spring.turbo.module.security.filter.TokenAuthenticationFilterFactory;
import spring.turbo.module.security.jwt.AbstractJwtTokenToUserConverter;
import spring.turbo.module.security.jwt.AlgorithmFactory;
import spring.turbo.module.security.jwt.filter.JwtTokenAuthenticationFilter;
import spring.turbo.module.security.user.UserDetailsPlus;
import spring.turbo.util.RandomStringUtils;
import spring.turbo.webmvc.function.RequestPredicateFactories;
import spring.turbo.webmvc.token.TokenResolver;

import java.util.Optional;

@Component
class JwtAuthFilterFactory implements TokenAuthenticationFilterFactory {

    private final AlgorithmFactory algorithmFactory;
    private final TokenResolver tokenResolver;
    private final AuthenticationEventPublisher authenticationEventPublisher;

    public JwtAuthFilterFactory(AlgorithmFactory algorithmFactory, TokenResolver tokenResolver, AuthenticationEventPublisher authenticationEventPublisher) {
        this.algorithmFactory = algorithmFactory;
        this.tokenResolver = tokenResolver;
        this.authenticationEventPublisher = authenticationEventPublisher;
    }

    @Override
    public TokenAuthenticationFilter create() {
        JwtTokenAuthenticationFilter filter = new JwtTokenAuthenticationFilter();
        filter.setTokenResolver(tokenResolver);
        filter.setTokenToUserConverter(new JwtTokenToUserConverter(algorithmFactory));
        filter.setAuthenticationEventPublisher(authenticationEventPublisher);
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
