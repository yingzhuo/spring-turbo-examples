package spring.turbo.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.turbo.bean.Pair;
import spring.turbo.module.predefined.PredefinedSM2;
import spring.turbo.module.security.encoder.PasswordEncoderFactories;
import spring.turbo.module.security.hutool.jwt.SM2Algorithm;
import spring.turbo.module.security.jwt.AlgorithmFactory;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class ApplicationBootSecurity extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder("SM3");
    }

    @Bean
    AlgorithmFactory algorithmFactory() {
        final Pair<String, String> pair = PredefinedSM2.loadKeys(9);
        return () -> new SM2Algorithm(
                pair.getRequiredA(),
                pair.getRequiredB()
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf()
                .disable();

        http.cors()
                .disable();

        http.httpBasic();

        http.jee()
                .disable();

        http.formLogin()
                .disable();

        http.logout()
                .disable();

        http.rememberMe()
                .disable();

        http.x509()
                .disable();

        http.requestCache()
                .disable();

        http.authorizeHttpRequests()
                .antMatchers("/**/security/info").hasAnyRole("USER");
    }

}
