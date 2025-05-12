package com.example.demo.domain.entities.order;

import com.example.demo.domain.valueObjects.Address;

import lombok.Value;

@Value
public class Delivery {
    private final Address address;
    private final String phoneNumber;
    private final String deliveryStatus;

    public Delivery(OrderId orderId, Address address, String phoneNumber, String deliveryStatus) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.deliveryStatus = deliveryStatus;
    }

}
