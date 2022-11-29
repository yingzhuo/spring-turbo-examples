package examples.spring_security_jwt.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Component;
import spring.turbo.module.security.exception.SecurityExceptionHandlerImpl;

import java.io.IOException;

@Component
public class SecurityExceptionHandler extends SecurityExceptionHandlerImpl {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, RequestRejectedException requestRejectedException) throws IOException, ServletException {
        super.handle(request, response, requestRejectedException);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {
        super.commence(request, response, authenticationException);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        super.handle(request, response, accessDeniedException);
    }

}
