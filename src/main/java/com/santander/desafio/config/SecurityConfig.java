package com.santander.desafio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/usuarios").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(); 
        return http.build();
    }
  @Bean
public UserDetailsService users() {
    UserDetails user = User.builder()
        .username("admin")
        .password(new BCryptPasswordEncoder().encode("123456"))
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
}

}
