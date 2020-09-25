package com.rcbrasileiro.demosso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String helloWord() {
		return "Hello word!";
	}
	
	@GetMapping("/restricted")
	public String restricted() {
		return "to see this text you need to be logged in!";
	}
}
