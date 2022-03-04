package com.abcbank.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import com.abcbank.bean.Order;

@Component
public class Consumer1 {


	
	  @JmsListener(destination = "test-queue") public void receiveMessage(String
	  message) { System.out.println("Message Received .."+message); }
	 
	
	/*
	 * @JmsListener(destination = "test-external-queue") public void
	 * receiveOrder(Order order) { System.out.println("order Received .."+order); }
	 */
}
