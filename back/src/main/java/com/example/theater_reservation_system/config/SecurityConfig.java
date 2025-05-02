package com.example.theater_reservation_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login
        .loginPage("/login") //ログイン画面のルーティング
        .failureUrl("/login?error")
        .defaultSuccessUrl("/") //ログイン後のパス
        .permitAll())
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/css/**").permitAll()
            .requestMatchers("/","/login").permitAll() //ログイン無しで表示できる画面のパス
            .anyRequest().authenticated()
        );
    http.logout(login -> login
        .logoutSuccessUrl("/") //ログアウト後のパス
        .permitAll());
    return http.build();
  }
}
