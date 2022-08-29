package com.example.demo.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {

private static final String LOGIN_PAGE_URL = "/login";
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     //   corsCustomizer.corsCustomizer(http);
        http.cors(c -> {
            CorsConfigurationSource source = s -> {
                CorsConfiguration cc = new CorsConfiguration();
                cc.setAllowCredentials(true);
                cc.setAllowedOrigins(List.of("http://127.0.0.1:3000"));
                cc.addAllowedOrigin("http://localhost:3000");
                cc.setAllowedHeaders(List.of("*"));
                cc.setAllowedMethods(List.of("*"));
                return cc;
            };

            c.configurationSource(source);
        });
        return http.formLogin(form -> form
                .loginPage("/login")
                .permitAll()
        )
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().build();
    }

}