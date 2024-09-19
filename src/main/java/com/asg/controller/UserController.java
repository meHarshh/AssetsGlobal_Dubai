package com.asg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asg.dto.UserRequest;
import com.asg.dto.UserResponse;
import com.asg.service.UserService;
import com.asg.util.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "users/adduser")
	public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest userRequest) {
		
		return userService.addUser(userRequest);
	}
}
