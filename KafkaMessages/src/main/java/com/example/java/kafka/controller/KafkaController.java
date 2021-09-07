package com.example.java.kafka.controller;



import org.springframework.kafka.core.KafkaTemplate;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class KafkaController {
	
	private KafkaTemplate<String, String> template;
	
	public KafkaController(KafkaTemplate<String, String> template) {
		super();
		this.template = template;
	}
		
	
	@RequestMapping(method = RequestMethod.POST,value = "/kafka/produce")
	public void produce(@RequestParam String message) {
		this.template.send("first_topic", message);
	}
	
	
	

}
