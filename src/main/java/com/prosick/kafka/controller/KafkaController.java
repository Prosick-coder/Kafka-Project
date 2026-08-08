package com.prosick.kafka.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prosick.kafka.kafkacfg.KafkaJsonProducer;
import com.prosick.kafka.kafkacfg.ProducerClass;
import com.prosick.kafka.payload.User;

import jakarta.annotation.PostConstruct;

@RestController
public class KafkaController {

//	private ProducerClass producerClass;
//
//	public KafkaController(ProducerClass producerClass) {
//		super();
//		this.producerClass = producerClass;
//	}
	@Autowired
	private KafkaJsonProducer jsonProducer;
	
	@PostMapping("/publish")
	public String publish(@RequestBody User user) {
		jsonProducer.sendMessage(user);
		return user.toString();
	}
}
