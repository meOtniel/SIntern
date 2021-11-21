package com.sintern.api;

import com.sintern.security.utils.AuthenticationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

    AuthenticationUtils authenticationUtils;

    @GetMapping("/{token}")
    public ResponseEntity<AuthenticationUtils.UserDTO> validateToken(@PathVariable String token) {
        AuthenticationUtils.UserDTO user = authenticationUtils.validateToken(token);
        return ResponseEntity.ok()
                .body(user);
    }
}
