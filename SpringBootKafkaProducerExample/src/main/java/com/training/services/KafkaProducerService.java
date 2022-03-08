package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.training.model.Training;

@Service
public class KafkaProducerService {

	private static final String TOPIC = "Kafka_Topic";

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public void send(String message)
	{
		ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send(TOPIC, message);

		future.addCallback(new ListenableFutureCallback() {

			@Override
			public void onSuccess(Object result) {
				System.out.println(message+" Published");

			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println(message + " failed to publish");

			}

		});
	}
	
	
	@Autowired
	private KafkaTemplate<String,Object> kafkaTrainingTemplate;
	
	public void send(List<Training> training)
	{
		ListenableFuture<SendResult<String, Object>> future = kafkaTrainingTemplate.send(TOPIC, training);

		future.addCallback(new ListenableFutureCallback() {

			@Override
			public void onSuccess(Object result) {
				System.out.println(training+" Published");

			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println(training + " failed to publish");

			}

		});
	}
}
