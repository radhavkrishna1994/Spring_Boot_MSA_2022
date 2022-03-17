package com.training.events;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


import com.training.dtos.OrderRequestDto;
@NoArgsConstructor
@Data
public class OrderEvent implements Event{

    private UUID eventId=UUID.randomUUID();
    
   // private LocalDate eventDate=LocalDate.now();
    private OrderRequestDto orderRequestDto;
    private OrderStatus orderStatus;

    @Override
    public UUID getEventId() {
        return eventId;
    }

	
	 // @Override public LocalDate getDate() { return eventDate; }
	 

    public OrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        this.orderRequestDto = orderRequestDto;
        this.orderStatus = orderStatus;
    }
}
