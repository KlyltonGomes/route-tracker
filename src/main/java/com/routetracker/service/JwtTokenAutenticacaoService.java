package com.routetracker.service;

import com.routetracker.domain.entity.Usuario;
import com.routetracker.repository.UsuarioRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtTokenAutenticacaoService {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 4; // 4h
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";

    private final UsuarioRepository usuarioRepository;

    public JwtTokenAutenticacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String gerarToken(Usuario usuario) {
        String token = Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("roles", usuario.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();

        return TOKEN_PREFIX + token;
    }

    public UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            String jwt = token.replace(TOKEN_PREFIX, "").trim();
            try {
                String user = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(jwt)
                        .getBody()
                        .getSubject();

                if (user != null) {
                    Usuario usuario = usuarioRepository.findByEmail(user)
                            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

                    return new UsernamePasswordAuthenticationToken(
                            usuario.getUsername(),
                            usuario.getSenha(),
                            usuario.getAuthorities()
                    );
                }
            } catch (JwtException e) {
                System.err.println("Erro no token JWT: " + e.getMessage());
                return null;
            }
        }

        liberarCors(response);
        return null;
    }

    private void liberarCors(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
    }
    public String recuperarUsuario(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            String jwt = token.replace(TOKEN_PREFIX, "").trim();
            try {
                return Jwts.parserBuilder()
                        .setSigningKey(SECRET_KEY)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody()
                        .getSubject();
            } catch (JwtException e) {
                System.err.println("Erro no token JWT: " + e.getMessage());
            }
        }
        return null;
    }

}
