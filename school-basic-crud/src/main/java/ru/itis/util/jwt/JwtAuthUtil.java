package ru.itis.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.itis.model.Account;
import ru.itis.security.details.UserDetail;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;

@Component
@AllArgsConstructor
public class JwtAuthUtil {

    private static final long ACCESS_TOKEN_TIME = 1 * 60 * 1000;
    private static final long REFRESH_TOKEN_TIME = 10 * 60 * 1000;


    private static final Algorithm algorithm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));



    public Map<String, String> generateTokens(String subject, String authority, String issuer) {

        String accessToken = JWT.create()
                .withSubject(subject)
                .withExpiresAt(Instant.ofEpochSecond(Instant.now().getEpochSecond() + ACCESS_TOKEN_TIME))
                .withClaim("role", authority)
                .withIssuer(issuer)
                .sign(algorithm);

        String refreshToken = JWT.create()
                .withSubject(subject)
                .withExpiresAt(Instant.ofEpochSecond(Instant.now().getEpochSecond() + REFRESH_TOKEN_TIME))
                .withClaim("role", authority)
                .withIssuer(issuer)
                .sign(algorithm);

        return Map.of("accessToken", accessToken, "refreshToken", refreshToken);
    }

    public Authentication buildAuthentication(String token) throws JWTVerificationException {
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();

        DecodedJWT jwt = jwtVerifier.verify(token);

        String userRole = jwt.getClaim("role").asString();

        UserDetails userDetails = new UserDetail(
                Account.builder()
                        .role(Account.Role.valueOf(userRole))
                        .name(jwt.getSubject())
                        .build()
        );

        return new UsernamePasswordAuthenticationToken(userDetails,
                null,
                Collections.singleton(new SimpleGrantedAuthority(userRole)));
    }
}
