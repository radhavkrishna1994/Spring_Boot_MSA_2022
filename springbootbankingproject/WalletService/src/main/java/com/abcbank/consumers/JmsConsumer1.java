package com.abcbank.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer1 {

	@JmsListener(destination = "test-external-queue")
	public void receiveMessage(String message)
	{
		System.out.println("Received message.."+message);
	}
}
