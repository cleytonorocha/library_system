package com.github.cleyto_orocha.library_system.security;

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
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.github.cleyto_orocha.library_system.enums.UserRole;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    // Define o padrão mvc e o inspetor (Helper class to get information from the
    // HandlerMapping that would serve a specific request)
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    // Corrente de filtros de segurança que aplicarei na minha requisição e validar
    // se aquele usuário está autorizado para acessar a aplicação
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/**")).hasAnyAuthority(UserRole.ADMIN.getDescription(), UserRole.USER.getDescription())
                        .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/**")).hasAuthority(UserRole.ADMIN.getDescription())
                        .requestMatchers(mvc.pattern(HttpMethod.DELETE, "/api/**")).hasAuthority(UserRole.ADMIN.getDescription())
                        .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/**")).hasAuthority(UserRole.ADMIN.getDescription())
                        .requestMatchers(mvc.pattern(HttpMethod.POST, "/auth/login")).permitAll()
                        .requestMatchers(mvc.pattern(HttpMethod.POST, "/auth/register")).permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.frameOptions(f -> f.disable()))
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
