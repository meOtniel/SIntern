package com.sintern.security.filters;

import com.google.gson.Gson;
import com.sintern.exception.ApiError;
import com.sintern.exception.InvalidException;
import com.sintern.security.jwt.JwtUtil;
import com.sintern.security.service.SUserDetailsService;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    AuthenticationManager authenticationManager;

    JwtUtil jwtUtil;


    public AuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        final String username = req.getParameter("email");
        final String password = req.getParameter("password");
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password, new ArrayList<>()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
        String token = jwtUtil.generateToken((UserDetails) auth.getPrincipal());
        res.addCookie(new Cookie("token", token));
        res.setContentType("application/json");
        String json = "{\"token\":\""+token+"\"}";
        res.getOutputStream().write(json.getBytes());
        res.getOutputStream().flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse res, AuthenticationException failed) throws IOException {
        ApiError error = new ApiError(ZonedDateTime.now(), HttpStatus.UNAUTHORIZED, failed.getMessage());
        res.getOutputStream().write(failed.getMessage().getBytes());
        res.getOutputStream().flush();
    }

}