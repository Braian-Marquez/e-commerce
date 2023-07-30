package com.logicap.ecommerce.auth.controller;


import com.logicap.ecommerce.auth.model.request.AuthenticationRequest;
import com.logicap.ecommerce.auth.model.request.UserRequest;
import com.logicap.ecommerce.auth.model.response.AuthenticationResponse;
import com.logicap.ecommerce.auth.model.response.UserResponse;
import com.logicap.ecommerce.auth.service.UserDetailsCustomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserAuthController {

    private final UserDetailsCustomService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> signup(@Valid @RequestBody UserRequest user) throws IOException {
        UserResponse result = userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody @Valid AuthenticationRequest authenticationRequest)  {
        return ResponseEntity.ok(userDetailsService.login(authenticationRequest));
    }


}
