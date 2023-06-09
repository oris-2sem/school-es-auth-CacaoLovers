package ru.itis.security.config;

import lombok.AllArgsConstructor;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itis.security.filters.JwtAuthenticationFilter;
import ru.itis.security.filters.JwtAuthorizationFilter;
import ru.itis.security.provider.RefreshTokenAuthenticationProvider;

@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@AllArgsConstructor
public class SpringSecurityConfig {

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    private final RefreshTokenAuthenticationProvider refreshTokenAuthenticationProvider;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter,
                                                   JwtAuthorizationFilter jwtAuthorizationFilter) throws Exception {
        return httpSecurity
                .authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/auth/token/**").permitAll()
                .antMatchers(HttpMethod.POST, "/account/**").hasRole("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**").hasRole("ROLE_ADMIN")
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().disable()
                .csrf().disable()
                .build();
    }

    @Autowired
    public void relateAccountServiceAndPasswordEncoder(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(refreshTokenAuthenticationProvider);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }



}
