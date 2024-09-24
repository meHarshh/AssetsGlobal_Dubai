package com.asg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asg.entity.Subscriber;
import com.asg.service.SubscriberService;
import com.asg.util.ResponseStructure;

@CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
@RestController
public class SubscriberController {

	@Autowired
	private SubscriberService subscriberService;

	@PostMapping(value = "subscriber/addSubscriber")
	private ResponseEntity<ResponseStructure<Subscriber>> addSubscriber(@RequestBody Subscriber subscriber) {
		return subscriberService.addSubscriber(subscriber);
	}

}
