package com.asg.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.asg.dto.UserRequest;
import com.asg.dto.UserResponse;
import com.asg.entity.User;
import com.asg.repo.UserRepository;
import com.asg.service.UserService;
import com.asg.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ResponseStructure<UserResponse> responseStructure;

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> addUser(UserRequest userRequest) {
		User user = mapToEntity(userRequest);
		user = userRepository.save(user);
		UserResponse userResponse = mapToResponse(user);

		String message = String.format(
				"Thank you for expressing your interest, %s! Our team will reach out to you shortly.",
				user.getUserName());

		return ResponseEntity
				.ok(responseStructure.setMessage(message).setData(userResponse).setStatus(HttpStatus.OK.value()));
	}

	private UserResponse mapToResponse(User user) {
		UserResponse response = new UserResponse();
		response.setUserId(user.getUserId());
		response.setUserName(user.getUserName());
		response.setUserEmail(user.getUserEmail());
		response.setUserContact(user.getUserContact());
		response.setMessage(user.getMessage());
		return response;
	}

	private User mapToEntity(UserRequest userRequest) {
		User user = new User();
		user.setUserName(userRequest.getUserName());
		user.setUserContact(userRequest.getUserContact());
		user.setUserEmail(userRequest.getUserEmail());
		user.setMessage(userRequest.getMessage());
		return user;
	}
}
