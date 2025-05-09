package com.example.demo.domain.entities.order;

import com.example.demo.domain.entities.orderItem.OrderItem;
import com.example.demo.domain.entities.restaurant.RestaurantId;
import com.example.demo.domain.entities.user.UserId;
import com.example.demo.domain.valueObjects.OrderStatus;

import lombok.Data;

@Data
public class Order {
    OrderId orderId;
    UserId userId;
    RestaurantId restaurantId;
    double totalPrice;
    OrderStatus status;

    private Order(OrderId orderId, UserId userId, RestaurantId restaurantId) {
        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalPrice = 0;
        this.status = OrderStatus.PENDING; // Default status
    }

    public static Order createOrder(UserId userId, RestaurantId restaurantId,
            Iterable<OrderItem> orderItems) {
        OrderId orderId = new OrderId(java.util.UUID.randomUUID());

        if (orderItems == null || !orderItems.iterator().hasNext()) {
            throw new IllegalArgumentException("Order items cannot be null or empty");
        }

        Order order = new Order(orderId, userId, restaurantId);

        for (OrderItem orderItem : orderItems) {
            if (orderItem.getQuantity() <= 0) {
                throw new IllegalArgumentException("Order item quantity must be greater than zero");
            }

            order.setTotalPrice(order.getTotalPrice() + orderItem.getPrice() * orderItem.getQuantity());
        }

        return order;
    }
}
