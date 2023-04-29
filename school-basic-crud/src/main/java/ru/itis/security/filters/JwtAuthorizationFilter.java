package ru.itis.security.filters;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.util.jwt.AuthorizationRequestHeaderUtil;
import ru.itis.util.jwt.JwtAuthUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtAuthUtil jwtAuthUtil;
    private final AuthorizationRequestHeaderUtil authorizationRequestHeaderUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("auth/login")){
            filterChain.doFilter(request, response);
        } else {
            if (authorizationRequestHeaderUtil.hasAuthorizationToken(request)) {
                String token = authorizationRequestHeaderUtil.getToken(request);

                Authentication authentication = jwtAuthUtil.buildAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
