package com.risam.springsecurity01.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
         * 1.开启请求认证
         * 2.对请求进行过滤
         * 3.登录策略（默认登录界面）
         */
        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers(HttpMethod.GET, "/index").permitAll()
                .requestMatchers(HttpMethod.GET, "/hello").authenticated())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
