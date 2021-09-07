package com.example.java.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KafkaMessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMessagesApplication.class, args);
	}

}
