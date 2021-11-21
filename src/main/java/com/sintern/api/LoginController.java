package com.sintern.api;

import com.sintern.security.utils.AuthenticationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    private AuthenticationUtils authenticationUtils;

    @Autowired
    public LoginController(AuthenticationUtils authenticationUtils) {
        this.authenticationUtils = authenticationUtils;
    }

    @Transactional
    @GetMapping("/{token}")
    public ResponseEntity<AuthenticationUtils.UserDTO> validateToken(@PathVariable String token) {
        AuthenticationUtils.UserDTO user = authenticationUtils.validateToken(token);
        return ResponseEntity.ok()
                .body(user);
    }
}
