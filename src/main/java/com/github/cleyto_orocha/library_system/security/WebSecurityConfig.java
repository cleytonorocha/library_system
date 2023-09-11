package com.github.cleyto_orocha.library_system.security;

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
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

// Indica para o spring que aqui a gente está desabilitando as configurações dele e adicionando a nossa.

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

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
                // Desliga a configuração
                .csrf(csrg -> csrg.disable())
                // Indica ao spring se você quer uma aplicação stateless ou stateful. Neste caso
                // stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Autoriza as requisições.
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/**")).permitAll()
                        .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/**")).permitAll()
                        .requestMatchers(mvc.pattern(HttpMethod.DELETE, "/api/**")).permitAll()
                        .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/**")).permitAll()

                        .requestMatchers(mvc.pattern(HttpMethod.POST, "/auth/login")).permitAll()
                        .requestMatchers(mvc.pattern(HttpMethod.POST, "/auth/register")).permitAll()
                        .anyRequest().authenticated())

                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
