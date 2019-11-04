package com.alexxstepan.taskmanagement.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

//	@RequestMapping("/logout")
//	public void logout() {
//
//	}
}
