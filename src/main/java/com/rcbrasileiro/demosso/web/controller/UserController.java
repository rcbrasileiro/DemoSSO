package com.rcbrasileiro.demosso.web.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {
	
    @GetMapping("/principal")
    public Principal principal(Principal principal) {
        return principal;
    }
    
    @GetMapping("/me")
    public Principal me(Principal principal) {
        return principal;
    }
}
