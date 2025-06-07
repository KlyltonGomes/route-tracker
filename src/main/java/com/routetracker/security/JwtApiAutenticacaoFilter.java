package com.routetracker.security;

import com.routetracker.repository.UsuarioRepository;
import com.routetracker.service.JwtTokenAutenticacaoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtApiAutenticacaoFilter extends OncePerRequestFilter {

    @Autowired
    private final JwtTokenAutenticacaoService jwtService;
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public JwtApiAutenticacaoFilter(JwtTokenAutenticacaoService jwtService, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) {
        try {
            String username = jwtService.recuperarUsuario(req);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                var usuario = usuarioRepository.findByEmail(username).orElse(null);

                if (usuario != null) {
                    var auth = new UsernamePasswordAuthenticationToken(
                            usuario, null, usuario.getAuthorities()
                    );
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
            chain.doFilter(req, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

