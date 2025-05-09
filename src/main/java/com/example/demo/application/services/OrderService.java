package com.example.demo.application.services;

import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.entities.order.Order;
import com.example.demo.domain.entities.order.OrderId;
import com.example.demo.domain.repositories.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrderById(String orderId) {
        OrderId n = new OrderId(UUID.fromString(orderId));

        return orderRepository.findByOrderId(n);
    }

}
