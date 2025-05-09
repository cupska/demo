package com.example.demo.domain.services;

import com.example.demo.domain.entities.order.OrderId;
import com.example.demo.domain.repositories.OrderRepository;

public class OrderItemService {
    private final OrderRepository orderRepository;

    public OrderItemService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void findAllByOrderId(OrderId orderId) throws IllegalArgumentException {
        Boolean isOrderIdExists = orderRepository.existsByOrderId(orderId);

        if (!isOrderIdExists) {
            throw new IllegalArgumentException("Order ID does not exist");
        }
    }
}
