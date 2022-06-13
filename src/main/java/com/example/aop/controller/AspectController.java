package com.example.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.annotations.LogConfig;

@RestController
public class AspectController {

	@GetMapping("/")
	@LogConfig
	public String getData() {
		return "Hello World";
	}
}
