package com.example.demo.application.services;

import java.util.UUID;

import com.example.demo.domain.entities.order.OrderId;
import com.example.demo.domain.repositories.OrderItemRepository;
import com.example.demo.domain.valueObjects.OrderItem;

public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final com.example.demo.domain.services.OrderItemService orderItemService;

    public OrderItemService(OrderItemRepository orderItemRepository,
            com.example.demo.domain.services.OrderItemService orderItemService) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemService = orderItemService;
    }

    public Iterable<OrderItem> getAllOrderItemsByOrderId(String orderId) {
        OrderId n = new OrderId(UUID.fromString(orderId));
        orderItemService.findAllByOrderId(n);

        return orderItemRepository.findAllByOrderId(n);
    }
}
