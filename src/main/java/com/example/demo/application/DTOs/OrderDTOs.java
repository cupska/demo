package com.example.demo.application.DTOs;

public record OrderDTOs() {
    public record CreateOrderRequestDTO(
            String userId,
            String restaurantId,
            OrderItemDTO[] orderItems,
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
