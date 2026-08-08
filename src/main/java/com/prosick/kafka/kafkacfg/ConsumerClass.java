package com.prosick.kafka.kafkacfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.prosick.kafka.payload.User;

@Service
public class ConsumerClass {

	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerClass.class);
	
	@KafkaListener(topics = "${spring.kafka.topic}", groupId = "my-spring-group")
	public void consume(User message) {
		LOGGER.info(String.format("Message received -> %s", message));
	}
	
}
