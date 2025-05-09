package com.example.demo.domain.entities.orderItem;

import com.example.demo.domain.entities.menu.MenuId;
import com.example.demo.domain.entities.order.OrderId;

import lombok.Value;

@Value
public class OrderItem {
    OrderItemId orderItemId;
    OrderId orderId;
    MenuId menuId;
    short quantity;
    double price;
}
