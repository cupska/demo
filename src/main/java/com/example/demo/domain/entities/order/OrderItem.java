package com.example.demo.domain.entities.order;

import com.example.demo.domain.entities.menu.MenuId;

import lombok.Value;

@Value
public class OrderItem {
    OrderId orderId;
    MenuId menuId;
    short quantity;
    double price;
}
