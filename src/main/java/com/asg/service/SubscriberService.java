package com.asg.service;

import org.springframework.http.ResponseEntity;

import com.asg.entity.Subscriber;
import com.asg.util.ResponseStructure;

public interface SubscriberService {

	ResponseEntity<ResponseStructure<Subscriber>> addSubscriber(Subscriber subscriber);

}	
