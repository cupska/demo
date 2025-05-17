package com.example.demo.application.DTOs;

import java.util.List;

import com.example.demo.domain.entities.order.orderItem.OrderItem;

public record OrderDTOs() {
        public record CreateOrderRequestDTO(
                        String userId,
                        String restaurantId,
                        List<OrderItem> orderItems,
                        String deliveryMethod,
                        DeliveryDTO delivery) {
        }

        public record OrderItemDTO(
                        String menuId,
                        int quantity) {

        }

        private record DeliveryDTO(
                        String address,
                        String phoneNumber) {
        }
}
