package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	Environment env;

	@GetMapping("/status/check")
	public String status() {
		return "working......."+env.getProperty("local.server.port");
	}
	
	//@PreAuthorize("hasRole('developer') or #id==")
	//@PreAuthorize("hasAuthority('ROLE_developer') or #id==#jwt.subject")
	@PreAuthorize("#id==#jwt.subject")
	//@PostAuthorize
	//@Secured("ROLE_developer")
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable String id,@AuthenticationPrincipal Jwt jwt){
		return "Delete user with id "+id+"jwt subject"+jwt.getSubject();
		
	 
	}
	
	@PostAuthorize("returnObject.userid==#jwt.subject")
	@GetMapping(path="/{id}")
	public UserRest getUser(@PathVariable String id,@AuthenticationPrincipal Jwt jwt){
		return new UserRest("ramya","kommineni","f0e46826-0f61-4f3b-b394-2244a4d25211");
			
		 
		}
	
	
	
}
