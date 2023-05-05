package examples.spring_security_jwt.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.authentication.UserDetailsFinder;

@Component
public class InMemoryTokenUserDetailsFinder implements UserDetailsFinder {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public InMemoryTokenUserDetailsFinder(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsernameAndPassword(String username, String password) throws AuthenticationException {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails == null) {
            return null;
        }

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            return userDetails;
        } else {
            return null;
        }
    }

}
