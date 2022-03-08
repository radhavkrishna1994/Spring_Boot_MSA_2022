package com.training.consumers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.training.model.Order;

@Component
public class JmsConsumer {

	
	/*
	 * @JmsListener(destination = "test-queue-internal") public void
	 * receiveMessage(String message) {
	 * System.out.println("Message Received:"+message); }
	 */
	
	
	/*
	 * @JmsListener(destination = "test-queue-external") public void
	 * receiveMessage(String message) {
	 * System.out.println("Message Received:"+message); }
	 */
	 
	
	
	/*
	 * @JmsListener(destination = "test-queue-external") public void
	 * receiveOrder(Order order) { System.out.println(order + "Received..."); }
	 */
	 
	 
	
	/*
	 * @JmsListener(destination = "test-queue-external") public void
	 * receiveOrder(List<Order> orders) { System.out.println(orders +
	 * "Received..."); }
	 */
	
}
