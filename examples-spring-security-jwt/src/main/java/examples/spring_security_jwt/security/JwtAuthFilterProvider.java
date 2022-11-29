package examples.spring_security_jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.filter.JwtTokenAuthenticationFilter;
import spring.turbo.module.security.filter.TokenAuthenticationFilter;
import spring.turbo.module.security.filter.TokenAuthenticationFilterFactory;
import spring.turbo.webmvc.token.TokenResolver;

@Component
public class JwtAuthFilterProvider implements TokenAuthenticationFilterFactory {

    private final TokenResolver tokenResolver;
    private final TokenToUserConverter tokenToUserConverter;

    @Autowired
    public JwtAuthFilterProvider(@Qualifier("primaryTokenResolver") TokenResolver tokenResolver, TokenToUserConverter tokenToUserConverter) {
        this.tokenResolver = tokenResolver;
        this.tokenToUserConverter = tokenToUserConverter;
    }

    @Override
    public TokenAuthenticationFilter create() {
        final JwtTokenAuthenticationFilter filter = new JwtTokenAuthenticationFilter();
        filter.setTokenResolver(tokenResolver);
        filter.setTokenToUserConverter(tokenToUserConverter);
        return filter;
    }

}
