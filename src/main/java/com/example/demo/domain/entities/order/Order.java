package com.example.demo.domain.entities.order;

import java.util.Optional;
import java.util.stream.Stream;

import com.example.demo.domain.entities.restaurant.RestaurantId;
import com.example.demo.domain.entities.user.UserId;

import lombok.Data;

@Data
public class Order {
    OrderId orderId;
    UserId userId;
    RestaurantId restaurantId;
    double totalPrice;
    OrderStatus status;
    OrderItem[] orderItems;
    DeliveryMethod deliveryMethod;
    Delivery delivery;

    private Order() {
        this.orderId = new OrderId(java.util.UUID.randomUUID());
    }

    public static Order createOrder(UserId userId, RestaurantId restaurantId, OrderItem[] orderItems,
            DeliveryMethod deliveryMethod,
            Delivery delivery) {

        if (orderItems == null || orderItems.length <= 0) {
            throw new IllegalArgumentException("Order items cannot be null or empty");
        }

        Order order = new Order();

        order.setTotalPrice(calculateTotalPrice(orderItems));

        return order;
    }

    private static double calculateTotalPrice(OrderItem[] orderItems) {
        return Stream.of(orderItems)
                .mapToDouble(item -> {
                    if (item.getQuantity() <= 0) {
                        throw new IllegalArgumentException("Order item quantity must be greater than zero");
                    }

                    return item.getPrice() * item.getQuantity();
                })
                .sum();
    }
}
