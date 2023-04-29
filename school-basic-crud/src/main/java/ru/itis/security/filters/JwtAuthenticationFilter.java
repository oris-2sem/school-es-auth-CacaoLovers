package ru.itis.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import ru.itis.security.details.UserDetail;
import ru.itis.security.model.RefreshTokenAuthentication;
import ru.itis.util.jwt.AuthorizationRequestHeaderUtil;
import ru.itis.util.jwt.JwtAuthUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public static final String USERNAME_PARAMETER = "name";
    public static final String AUTHENTICATION_URL = "auth/token";

    private final ObjectMapper objectMapper;
    private final JwtAuthUtil jwtAuthUtil;
    private final AuthorizationRequestHeaderUtil authorizationRequestHeaderUtil;

    public JwtAuthenticationFilter(AuthenticationConfiguration authenticationConfiguration,
                                   ObjectMapper objectMapper,
                                   JwtAuthUtil jwtAuthUtil,
                                   AuthorizationRequestHeaderUtil authorizationRequestHeaderUtil) throws Exception {
        super(authenticationConfiguration.getAuthenticationManager());
        this.objectMapper = objectMapper;
        this.jwtAuthUtil = jwtAuthUtil;
        this.authorizationRequestHeaderUtil = authorizationRequestHeaderUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if(authorizationRequestHeaderUtil.hasAuthorizationToken(request)){
            String refreshToken = authorizationRequestHeaderUtil.getToken(request);
            RefreshTokenAuthentication authentication = new RefreshTokenAuthentication(refreshToken);
            return super.getAuthenticationManager().authenticate(authentication);
        } else {
            return super.attemptAuthentication(request, response);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        response.setContentType("application/json");

        GrantedAuthority authority = authResult.getAuthorities().stream().findFirst().orElseThrow();
        String name = ((UserDetail) authResult.getPrincipal()).getUsername();
        String issuer = request.getRequestURL().toString();

        Map<String, String> tokens = jwtAuthUtil.generateTokens(name, authority.getAuthority(), issuer);

        objectMapper.writeValue(response.getOutputStream(), tokens);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
