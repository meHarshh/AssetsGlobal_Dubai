package com.asg.service;

import org.springframework.http.ResponseEntity;

import com.asg.dto.UserRequest;
import com.asg.dto.UserResponse;
import com.asg.util.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<UserResponse>> addUser(UserRequest userRequest);

}
