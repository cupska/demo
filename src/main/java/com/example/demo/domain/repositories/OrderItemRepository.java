package com.example.demo.domain.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.domain.entities.menu.MenuId;
import com.example.demo.domain.entities.order.OrderId;
import com.example.demo.domain.entities.orderItem.OrderItem;
import com.example.demo.domain.entities.orderItem.OrderItemId;

public interface OrderItemRepository extends Repository<OrderItem, OrderItemId> {

    Iterable<OrderItem> save(Iterable<OrderItem> orderItems);

    Iterable<OrderItem> findAllByOrderId(OrderId orderId);

    Iterable<OrderItem> findByMenuId(MenuId menuId);

    Iterable<OrderItem> findByQuantity(int quantity);

}
