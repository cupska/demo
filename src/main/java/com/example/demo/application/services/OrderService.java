package com.example.demo.application.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.checkerframework.checker.units.qual.A;

import com.example.demo.application.DTOs.OrderDTOs.CreateOrderRequestDTO;
import com.example.demo.application.DTOs.OrderDTOs.OrderItemDTO;
import com.example.demo.domain.entities.menu.MenuId;
import com.example.demo.domain.entities.order.Order;
import com.example.demo.domain.entities.order.OrderId;
import com.example.demo.domain.entities.order.orderItem.OrderItem;
import com.example.demo.domain.entities.restaurant.RestaurantId;
import com.example.demo.domain.entities.user.UserId;
import com.example.demo.domain.repositories.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrderDetailById(String orderId) {
        OrderId n = new OrderId(UUID.fromString(orderId));

        return orderRepository.findByOrderId(n);
    }

    public void createOrder(CreateOrderRequestDTO payload) {

        UserId userId = new UserId(UUID.fromString(payload.userId()));
        RestaurantId restaurantId = new RestaurantId(UUID.fromString(payload.restaurantId()));
        Order order = Order.createOrder(userId,
                restaurantId, payload., null, null);

        orderRepository.save(order);
    }

}
