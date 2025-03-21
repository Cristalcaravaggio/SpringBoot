package com.b2b.spring.boot.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Abilita l'uso di @PreAuthorize
@RequiredArgsConstructor
public class SecurityConfig {

  private final AuthorizationHeaderFilter authorizationHeaderFilter;
  private final AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults())
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(authorizationHeaderFilter, UsernamePasswordAuthenticationFilter.class)
             .authorizeHttpRequests(
            authReq -> authReq.requestMatchers(HttpMethod.GET, "/api/auth/login").permitAll()
                    .requestMatchers("/api/user/**").permitAll()
                    .anyRequest().authenticated());
    return httpSecurity.build();
  }

}
