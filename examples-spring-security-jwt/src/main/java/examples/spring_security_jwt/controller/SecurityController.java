package examples.spring_security_jwt.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.turbo.exception.ValidationException;
import spring.turbo.module.security.jwt.JwtTokenFactory;
import spring.turbo.module.security.token.Token;
import spring.turbo.module.security.user.CurrentToken;
import spring.turbo.webmvc.api.Json;

@RestController
@RequestMapping("/security")
public class SecurityController {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenFactory tokenFactory;

    public SecurityController(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder, JwtTokenFactory tokenFactory) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
        this.tokenFactory = tokenFactory;
    }

    @PostMapping("/login")
    public Json login(@Validated @RequestBody LoginVO vo, BindingResult bindingResult) {
        ValidationException.raiseIfNecessary(bindingResult);

        UserDetails user;

        try {
            user = userDetailsManager.loadUserByUsername(vo.getUsername());
        } catch (UsernameNotFoundException e) {
            throw new IllegalArgumentException("用户名错误");
        }

        if (passwordEncoder.matches(vo.getPassword(), user.getPassword())) {
            var data = JwtTokenFactory.Data.newInstance()
                    .addPayload("username", user.getUsername())
                    .addPayload("roles", getRole(user));

            var token = tokenFactory.create(data);

            return Json.newInstance()
                    .payload("token", token);
        } else {
            throw new IllegalArgumentException("密码错误");
        }
    }

    private String[] getRole(UserDetails userDetails) {
        return userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::toString)
                .map(r -> r.substring("ROLE_".length()))
                .toArray(String[]::new);
    }

    @GetMapping("/test-token")
    public Json testToken(@CurrentToken Token token) {
        return Json.newInstance()
                .payload("token", token);
    }

}
