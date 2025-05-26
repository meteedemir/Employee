package com.example.EmployeeCRUD.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class EmployeeSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        );

        // use HTTP basic auth
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery (CSRF)
        //in general, not required for stateless REST APIs that use POST, ...
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


}
