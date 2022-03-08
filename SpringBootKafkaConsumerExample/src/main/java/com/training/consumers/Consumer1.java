package com.training.consumers;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.training.model.Training;

@Component
public class Consumer1 {

	
	  @KafkaListener(topics = "Kafka_Topic",groupId = "test-group") public void
	  getMessage(List<Training> training) {
	  System.out.println("Message Consumed:"+training); }
	 
	
	/*
	 * @KafkaListener(topics = "Kafka_Topic",groupId = "test-group") public void
	 * getMessage(String message) { System.out.println("Message Consumed:"+message);
	 * }
	 */
	 
}
