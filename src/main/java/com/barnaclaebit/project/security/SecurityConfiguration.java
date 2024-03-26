package com.barnaclaebit.project.security;

import com.barnaclaebit.project.entity.dto.AuthenticationDTO;
import com.barnaclaebit.project.utils.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) //enable or disable the default configuration
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //saver or not the user session
                .authorizeHttpRequests(authorize -> //add the endpoints in app
                        authorize.requestMatchers(HttpMethod.POST, EndPoints.PUBLIC_POST.toArray(new String[EndPoints.PUBLIC_POST.size()])).permitAll()
                                .requestMatchers(HttpMethod.GET, EndPoints.PUBLIC_GET.toArray(new String[EndPoints.PUBLIC_GET.size()])).permitAll()
                                .requestMatchers(HttpMethod.PUT, EndPoints.PUBLIC_PUT.toArray(new String[EndPoints.PUBLIC_PUT.size()])).permitAll()
                                .requestMatchers(HttpMethod.DELETE, EndPoints.PUBLIC_DELETE.toArray(new String[EndPoints.PUBLIC_DELETE.size()])).permitAll()
                                .anyRequest().authenticated()
                        //case roles is necessary.hasRole("ADMIN")
                ).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    protected AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
