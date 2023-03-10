package com.ideal.quote.controller;

import com.ideal.quote.domain.user.AuthenticationData;
import com.ideal.quote.domain.user.User;
import com.ideal.quote.infra.security.DataTokenJWT;
import com.ideal.quote.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public
class AuthenticationController {

    @Autowired
    private
    AuthenticationManager manager;

    @Autowired
    private
    TokenService tokenService;

    @PostMapping
    public
    ResponseEntity login( @RequestBody @Valid AuthenticationData data ) {
        var authToken = new UsernamePasswordAuthenticationToken ( data.login (), data.password () );
        var auth = manager.authenticate ( authToken );
        var tokenJWT = tokenService.generateToken ( (User) auth.getPrincipal () );
        return ResponseEntity.ok ( new DataTokenJWT ( tokenJWT ) );
    }

}
