package com.risam.springsecurity02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/login.html").permitAll()
                .requestMatchers(HttpMethod.GET, "/index").permitAll()
                .anyRequest().authenticated())
                .formLogin(FormLoginConfigurer-> FormLoginConfigurer.loginPage("/login.html")
                        //覆盖默认跳转路径
                        .loginProcessingUrl("/doLogin")
                        //覆盖默认表单用户名称
                        .usernameParameter("uname")
                        //覆盖默认表单密码名称
                        .passwordParameter("passwd")
                        .defaultSuccessUrl("/index")
                        .failureUrl("/login.html"));
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
