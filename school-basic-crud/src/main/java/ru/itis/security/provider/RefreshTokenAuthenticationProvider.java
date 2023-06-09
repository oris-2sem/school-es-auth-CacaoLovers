package ru.itis.security.provider;

import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.itis.util.jwt.JwtAuthUtil;

@Component
@AllArgsConstructor
public class RefreshTokenAuthenticationProvider implements AuthenticationProvider {

    private final JwtAuthUtil jwtAuthUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String refreshToken = (String) authentication.getCredentials();

        return jwtAuthUtil.buildAuthentication(refreshToken);


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return RefreshTokenAuthenticationProvider.class.isAssignableFrom(authentication);
    }
}
