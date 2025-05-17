package com.example.demo.domain.entities.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.example.demo.domain.entities.order.orderItem.OrderItem;
import com.example.demo.domain.entities.restaurant.RestaurantId;
import com.example.demo.domain.entities.user.UserId;
import com.example.demo.domain.valueObjects.Money;

import lombok.Data;

@Data
public class Order {
    private final OrderId orderId;
    final UserId userId;
    final RestaurantId restaurantId;
    private Money totalPrice;
    OrderStatus status;
    List<OrderItem> orderItems;
    DeliveryMethod deliveryMethod;
    Delivery delivery;

    private Order(UserId userId, RestaurantId restaurantId) {
        this.orderId = new OrderId(java.util.UUID.randomUUID());
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.status = OrderStatus.PENDING;
        this.orderItems = new ArrayList<>();
        this.totalPrice = new Money(0);

    }

    public static Order createOrder(UserId userId, RestaurantId restaurantId, List<OrderItem> orderItems,
            DeliveryMethod deliveryMethod,
            Delivery delivery) {

        Order order = new Order(userId, restaurantId);
        order.orderItems = orderItems;
        order.totalPrice = orderItems.stream()
                .map(OrderItem::subTotal)
                .reduce(new Money(0), Money::add);

        return order;
    }

    public Order addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            throw new IllegalStateException("Order items list is not initialized");
        }

        if (orderItems.stream().anyMatch(OrderItem -> OrderItem.getMenuId().equals(orderItem.getMenuId()))) {
            throw new IllegalArgumentException("Order item already exists in the order");
        }

        orderItems.add(orderItem);
        totalPrice.add(orderItem.subTotal());

        return this;
    }
}
