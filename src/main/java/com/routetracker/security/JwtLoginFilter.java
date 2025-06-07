//package com.routetracker.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.routetracker.domain.entity.Usuario;
//import com.routetracker.service.JwtTokenAutenticacaoService;
//import io.jsonwebtoken.io.IOException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
//
//    @Autowired
//    private final AuthenticationManager authenticationManager;
//    @Autowired
//    private final JwtTokenAutenticacaoService jwtService;
//
//    public JwtLoginFilter(AuthenticationManager authenticationManager, JwtTokenAutenticacaoService jwtService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtService = jwtService;
//        setFilterProcessesUrl("/login"); // Rota de login
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {
//        try {
//            Usuario usuarioLogin = new ObjectMapper()
//                    .readValue(req.getInputStream(), Usuario.class); //classe Usuario
//
//            UsernamePasswordAuthenticationToken authToken =
//                    new UsernamePasswordAuthenticationToken(
//                            usuarioLogin.getUsername(),
//                            usuarioLogin.getPassword()
//                    );
//
//            return authenticationManager.authenticate(authToken);
//        } catch (IOException | java.io.IOException e) {
//            throw new RuntimeException("Erro ao autenticar usuário", e);
//        }
//    }
//
//
//    @Override
//    protected void successfulAuthentication(
//            HttpServletRequest req,
//            HttpServletResponse res,
//            FilterChain chain,
//            Authentication auth
//    ) {
//        Usuario usuario = (Usuario) auth.getPrincipal();
//        String token = jwtService.gerarToken(usuario);
//
//        res.setHeader("Authorization", "Bearer " + token);
//        res.setContentType("application/json");
//        try {
//            res.getWriter().write("{\"token\":\"" + token + "\"}");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
