package examples.spring_security_jwt.security;

import cn.hutool.json.JSONArray;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSigner;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.jwt.AbstractJwtTokenToUserConverter;
import spring.turbo.module.security.user.UserDetailsPlus;

@Component
public class TokenToUserConverter extends AbstractJwtTokenToUserConverter {

    public TokenToUserConverter(JWTSigner signer) {
        super(signer);
    }

    @Override
    protected UserDetails doAuthenticate(String rawToken, JWT jwt) throws AuthenticationException {
        var id = (long) jwt.getPayload("id");
        var username = (String) jwt.getPayload("username");
        var roles = (String[]) ((JSONArray) jwt.getPayload("roles")).toArray(String[].class);
        return UserDetailsPlus.builder()
                .id(id)
                .username(username)
                .roles(roles)
                .build();
    }

}
