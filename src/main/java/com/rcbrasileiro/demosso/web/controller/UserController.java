package com.rcbrasileiro.demosso.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcbrasileiro.demosso.domain.User;
import com.rcbrasileiro.demosso.service.IUserService;

@RestController()
@RequestMapping("user")
public class UserController {
	
	@Autowired
	public IUserService userService;

	@GetMapping("/principal")
	public ResponseEntity<Principal> principal(Principal principal) {
		return ResponseEntity.ok(principal);
	}

	@GetMapping("/me")
	public ResponseEntity<User> me() {
		return ResponseEntity.ok(userService.getUser());
	}
}
