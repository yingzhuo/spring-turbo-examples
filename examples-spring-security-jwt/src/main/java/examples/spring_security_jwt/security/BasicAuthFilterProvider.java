package examples.spring_security_jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.authentication.UserDetailsFinder;
import spring.turbo.module.security.filter.BasicAuthenticationFilter;
import spring.turbo.module.security.filter.BasicAuthenticationFilterFactory;
import spring.turbo.webmvc.token.TokenResolver;

@Component
public class BasicAuthFilterProvider implements BasicAuthenticationFilterFactory {

    private final TokenResolver tokenResolver;
    private final UserDetailsFinder userDetailsFinder;

    @Autowired
    public BasicAuthFilterProvider(@Qualifier("basicTokenResolver") TokenResolver tokenResolver, UserDetailsFinder userDetailsFinder) {
        this.tokenResolver = tokenResolver;
        this.userDetailsFinder = userDetailsFinder;
    }

    @Override
    public BasicAuthenticationFilter create() {
        final BasicAuthenticationFilter filter = new BasicAuthenticationFilter();
        filter.setUserDetailsFinder(userDetailsFinder);
        filter.setTokenResolver(tokenResolver);
        return filter;
    }

}
