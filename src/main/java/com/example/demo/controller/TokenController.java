package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@GetMapping
	public Map<String,Object> getToken(@AuthenticationPrincipal Jwt jwt) {
		
		
		return Collections.singletonMap("principal",jwt);
		
	}

}
