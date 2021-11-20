package com.sintern.security.filters;

import com.sintern.security.jwt.JwtUtil;
import com.sintern.security.service.SUserDetailsService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthorizationFilter extends OncePerRequestFilter {

    JwtUtil jwtUtil;
    SUserDetailsService service;

    public AuthorizationFilter(JwtUtil jwtUtil, SUserDetailsService userServiceDetails) {
        this.jwtUtil = jwtUtil;
        this.service = userServiceDetails;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        Cookie authCookie = null;
        if (cookies != null) {
            authCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("token")).findAny().orElse(null);
        }

        String jwt = null;
        if (authCookie != null) {
            jwt = authCookie.getValue();
        }

        if (jwt != null) {
            String username = jwtUtil.extractUsername(jwt);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails user = service.loadUserByUsername(username);
                boolean validToken = jwtUtil.validateToken(jwt, user);
                if (validToken) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        chain.doFilter(request, response);
    }
}