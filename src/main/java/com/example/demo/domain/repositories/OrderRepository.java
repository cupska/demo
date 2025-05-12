package com.example.demo.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.example.demo.domain.entities.order.Order;
import com.example.demo.domain.entities.order.OrderId;
import com.example.demo.domain.entities.restaurant.RestaurantId;
import com.example.demo.domain.entities.user.UserId;
import com.example.demo.domain.valueObjects.OrderItem;
import com.example.demo.domain.valueObjects.OrderStatus;

@org.springframework.stereotype.Repository
public interface OrderRepository extends Repository<Order, OrderId> {

    Order save(Order order);

    List<Order> findByStatus(OrderStatus status);

    Optional<Order> findByOrderId(OrderId orderId);

    List<Order> findByUserId(UserId userId);

    List<Order> findByRestaurantId(RestaurantId restaurantId);

    Boolean existsByOrderId(OrderId orderId);
}
