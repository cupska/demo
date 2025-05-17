package com.example.demo.domain.entities.order.orderItem;

import com.example.demo.domain.entities.menu.MenuId;
import com.example.demo.domain.entities.order.OrderId;
import com.example.demo.domain.valueObjects.Money;

import lombok.Value;

@Value
public class OrderItem {
    OrderItemId orderItemId;
    OrderId orderId;
    MenuId menuId;
    short quantity;
    Money price;

    public OrderItem(OrderItemId orderItemId, OrderId orderId, MenuId menuId, short quantity, double price) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.price = new Money(price);

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    public Money subTotal() {
        return new Money(price.getAmount() * quantity);
    }
}
