package com.khlebnikovevgeniy.securityuserservice.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khlebnikovevgeniy.securityuserservice.domain.User;
import com.khlebnikovevgeniy.securityuserservice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
	
	private final UserService userService;
	
	@GetMapping("/users")
	ResponseEntity<List<User>>getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	
}
