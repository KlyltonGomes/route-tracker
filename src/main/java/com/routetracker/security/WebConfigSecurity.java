package com.routetracker.security;

import com.routetracker.repository.UsuarioRepository;
import com.routetracker.service.JwtTokenAutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebConfigSecurity {

    @Autowired
    private final UserDetailsService usuarioDetailsService;

    @Autowired
    private final JwtTokenAutenticacaoService jwtService;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public WebConfigSecurity(UserDetailsService usuarioDetailsService,
                             JwtTokenAutenticacaoService jwtService,
                             UsuarioRepository usuarioRepository) {
        this.usuarioDetailsService = usuarioDetailsService;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtApiAutenticacaoFilter jwtFilter = new JwtApiAutenticacaoFilter(jwtService, usuarioRepository);

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        //Rotas públicas
                        .requestMatchers("/auth/login", "/h2-console/**", "/usuario/cadastrar").permitAll()

                        //Rotas específicas por perfil
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        //.requestMatchers("/admin/motorista/{id}/detalhes").hasRole("ADMIN")
                        //.requestMatchers("/motorista/rota/criar").hasRole("MOTORISTA")
                        .requestMatchers("/motorista/**").hasAnyRole("MOTORISTA", "ADMIN")

                        //Toda outra rota exige autenticação
                        .anyRequest().authenticated()
                )
                .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.disable()); // necessário para liberar H2 em dev

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
