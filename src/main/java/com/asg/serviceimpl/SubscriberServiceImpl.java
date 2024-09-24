package com.asg.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.asg.entity.Subscriber;
import com.asg.repo.SubsrcriberRepository;
import com.asg.service.SubscriberService;
import com.asg.util.ResponseStructure;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubsrcriberRepository subsrcriberRepository;

	@Autowired
	private ResponseStructure<Subscriber> responseStructure;

	@Override
	public ResponseEntity<ResponseStructure<Subscriber>> addSubscriber(Subscriber subscriber) {
		responseStructure.setData(subsrcriberRepository.save(subscriber))
				.setMessage("Successfully subscribed to regular updates").setStatus(HttpStatus.OK.value());

		return ResponseEntity.ok(responseStructure);
	}

}
