package com.notax.notax_project.infra.springboot.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class HttpSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize ->
                authorize
                    .requestMatchers("/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/user").permitAll()
                    .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());
        return http.build();
    }
}
