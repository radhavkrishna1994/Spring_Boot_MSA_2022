package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Training;
import com.training.services.KafkaProducerService;

@RestController
public class KafkaController {

	@Autowired
	private KafkaProducerService producerService;

	@GetMapping("/publish/{message}")
	public void publish(@PathVariable("message") final String message)
	{
		producerService.send(message);

	}
	
	@PostMapping("/publish")
	public void publishTraining(@RequestBody List<Training> training)
	{
		producerService.send(training);

	}
}
