package com.risam.springsecurity02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class successWebSecurityConfigurer {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/login.html").permitAll()
                .requestMatchers(HttpMethod.GET, "/index").permitAll()
                .anyRequest().authenticated())
                .formLogin(FormLoginConfigurer -> FormLoginConfigurer
                        .successHandler(new MyAuthenticationSuccessHandler())
                        .failureUrl("/login.html"));
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
