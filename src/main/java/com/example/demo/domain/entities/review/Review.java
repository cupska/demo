package com.example.demo.domain.entities.review;

import com.example.demo.domain.entities.order.OrderId;
import com.example.demo.domain.entities.orderItem.OrderItemId;
import com.example.demo.domain.entities.user.UserId;

public class Review {
    ReviewId reviewId;
    UserId userId;
    OrderId orderId;
    OrderItemId orderItemId;
    byte rating;
    String comment;
}
