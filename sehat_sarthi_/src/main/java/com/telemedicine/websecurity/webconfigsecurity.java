package com.telemedicine.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class webconfigsecurity {

    @Autowired
    private configsercies configService; // your custom user details service

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())

            // 🔐 Authorization
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/Sign/**" ,"/css/**", "/js/**", "/image/**", "/images/**", "/webjars/**").permitAll()
                .requestMatchers("/Doctor/**", "/Doctor").hasRole("Doctor")
                .requestMatchers("/Patient/**", "/Patient").hasRole("Patient")
                .requestMatchers("/mentorship/**").hasAnyRole("Doctor","Patient")
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated()
            )

            // 🔑 Form Login
            .formLogin(login -> login
                .loginPage("/loginpage")
                .loginProcessingUrl("/submit")
                .successHandler(customAuthenticationSuccessHandler())
                .failureUrl("/loginpage?error=true")
                .permitAll()
            )

            // 🚪 Logout
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/loginpage?logout=true")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // 🎯 Custom redirect based on role
    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return (request, response, authentication) -> {
            var authorities = authentication.getAuthorities();
            String redirectUrl = "/";

            System.out.println("User Roles: " + authorities); // For debugging

            if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_Doctor"))) {
                redirectUrl = "/Doctor";
            } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_Patient"))) {
                redirectUrl = "/Patient";
            }

            response.sendRedirect(redirectUrl);
        };
    }
    
    
}
