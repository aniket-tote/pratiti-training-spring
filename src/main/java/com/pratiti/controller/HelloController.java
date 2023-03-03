package com.pratiti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	@GetMapping("/welcome")
	public String sayHello() {
		return "hello r";
	}
	
}
